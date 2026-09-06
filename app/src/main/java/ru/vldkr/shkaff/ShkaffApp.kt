package ru.vldkr.shkaff

import android.app.Application
import ru.vldkr.shkaff.di.Deps

class ShkaffApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Deps.init(this)
    }
}
