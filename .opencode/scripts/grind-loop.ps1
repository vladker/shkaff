# Цикл «делай карточки борда подряд»: каждый запуск — одна карточка через /grind
# (.opencode/command/grind.md), пока на борде .pi/kanban есть карточки new/doing.
# Запуск: powershell -File .opencode/scripts/grind-loop.ps1 [-Max 50]
# Останов: борд пуст (new/doing нет) либо 3 итерации подряд без прогресса (СТОП).
param(
    [int]$Max = 50,
    [string]$Model = ""
)

$tasks = Join-Path (Get-Location) ".pi/kanban/tasks"
if (-not (Test-Path $tasks)) { Write-Error "Борд не найден: $tasks (запускать из корня репо)"; exit 2 }

function Get-OpenCount {
    @(Get-ChildItem $tasks -Filter *.md | Where-Object {
        (Get-Content $_.FullName -TotalCount 8 -Encoding UTF8) -match '^status: (new|doing)$'
    }).Count
}

$stall = 0
$prev = -1
for ($i = 1; $i -le $Max; $i++) {
    $open = Get-OpenCount
    Write-Host "iter ${i}: open(new/doing)=$open"
    if ($open -eq 0) { Write-Host "БОРД ЧИСТ (new/doing); остались только waiting_device/done"; break }
    if ($open -eq $prev) { $stall++ } else { $stall = 0 }
    if ($stall -ge 3) { Write-Host "СТОП: 3 итерации без изменения числа открытых карточек"; break }
    $prev = $open
    $args = @("run", "--auto")
    if ($Model) { $args += @("--model", $Model) }
    $args += @("/grind")
    & opencode @args
    if ($LASTEXITCODE -ne 0) { Write-Host "opencode run завершился с кодом $LASTEXITCODE — останов"; break }
}
