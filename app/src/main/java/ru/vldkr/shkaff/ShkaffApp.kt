package ru.vldkr.shkaff

import android.app.Application
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.ui.theme.Ozon
import ru.vldkr.shkaff.ui.theme.ThemeMode

class ShkaffApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Deps.init(this)
        // Тема восстанавливается из настроек до первого кадра UI.
        Ozon.mode = if (Deps.themeIsLight()) ThemeMode.LIGHT else ThemeMode.DARK
    }
}
