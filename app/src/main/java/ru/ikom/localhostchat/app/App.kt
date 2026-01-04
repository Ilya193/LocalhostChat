package ru.ikom.localhostchat.app

import android.app.Application
import ru.ikom.localhostchat.di.DefaultAppContainer

class App : Application() {

    val appContainer = DefaultAppContainer(this)
}