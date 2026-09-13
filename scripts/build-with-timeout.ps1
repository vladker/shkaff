<#
  build-with-timeout.ps1 — Gradle-сборка с таймаутом (защита от зависаний).

  Использование:
    powershell -NoProfile -ExecutionPolicy Bypass -File scripts\build-with-timeout.ps1
    powershell -NoProfile -ExecutionPolicy Bypass -File scripts\build-with-timeout.ps1 -Task :app:testDebugUnitTest
    powershell -NoProfile -ExecutionPolicy Bypass -File scripts\build-with-timeout.ps1 -Task :app:assembleDebug -TimeoutSec 900

  Выходные коды:
    0      — успешно
    124    — таймаут: процесс убит (дерево + gradlew --stop + сиротские java/aapt2), повторный запуск допустим
    прочее — код ошибки Gradle
#>
param(
    [string]$Task = ":app:assembleDebug",
    [int]$TimeoutSec = 600
)

$ErrorActionPreference = "Continue"
$root = Split-Path -Parent $PSScriptRoot
$gradlew = Join-Path $root "gradlew.bat"

function Start-Gradle([string]$Args_) {
    $psi = New-Object System.Diagnostics.ProcessStartInfo
    $psi.FileName = "cmd.exe"
    $psi.Arguments = "/c `"$gradlew`" $Args_"
    $psi.WorkingDirectory = $root
    $psi.UseShellExecute = $false
    $psi.CreateNoWindow = $true
    return [System.Diagnostics.Process]::Start($psi)
}

function Stop-GradleWorld([int]$GuardSec) {
    Write-Host "  [1/3] gradlew --stop (guard ${GuardSec}с)..."
    $stop = Start-Gradle "--stop"
    $null = $stop.WaitForExit($GuardSec * 1000)
    if (-not $stop.HasExited) {
        & taskkill /T /F /PID $stop.Id 2>&1 | Out-Null
    }
    Write-Host "  [2/3] сиротские java (gradle)..."
    Get-CimInstance Win32_Process -Filter "Name='java.exe'" |
        Where-Object { $_.CommandLine -like "*gradle*" } |
        ForEach-Object { Stop-Process -Id $_.ProcessId -Force -ErrorAction SilentlyContinue }
    Write-Host "  [3/3] aapt2..."
    & taskkill /F /IM aapt2.exe 2>&1 | Out-Null
}

Write-Host ">> gradlew $Task (таймаут ${TimeoutSec}с)"
$sw = [System.Diagnostics.Stopwatch]::StartNew()
$proc = Start-Gradle $Task
$null = $proc.WaitForExit($TimeoutSec * 1000)
$sw.Stop()

if (-not $proc.HasExited) {
    Write-Host ""
    Write-Host "[timeout] Сборка не завершилась за ${TimeoutSec}с — принудительная остановка:" -ForegroundColor Red
    & taskkill /T /F /PID $proc.Id 2>&1 | Out-Null
    Stop-GradleWorld 30
    Write-Host "[timeout] Готово к повторному запуску (код 124)." -ForegroundColor Red
    exit 124
}

$code = $proc.ExitCode
$sec = [math]::Round($sw.Elapsed.TotalSeconds)
if ($code -eq 0) {
    Write-Host "[ok] $Task за ${sec}с"
} else {
    Write-Host "[fail] $Task завершилась с кодом $code за ${sec}с" -ForegroundColor Yellow
}
exit $code
