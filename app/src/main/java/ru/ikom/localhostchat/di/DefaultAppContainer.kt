package ru.ikom.localhostchat.di

import android.app.Application
import ru.ikom.localhostchat.di.core.CoreModule
import ru.ikom.localhostchat.di.core.DefaultCoreModule
import ru.ikom.localhostchat.di.features.DefaultFeaturesProvider
import ru.ikom.localhostchat.di.features.FeaturesProvider

class DefaultAppContainer(
    private val application: Application
) : AppContainer {

    private val coreModule: CoreModule by lazy {
        DefaultCoreModule(application)
    }

    override val featuresProvider: FeaturesProvider by lazy {
        DefaultFeaturesProvider(coreModule)
    }
}