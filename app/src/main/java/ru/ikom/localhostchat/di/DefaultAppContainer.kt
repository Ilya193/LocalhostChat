package ru.ikom.localhostchat.di

import android.app.Application
import ru.ikom.localhostchat.di.features.DefaultFeaturesProvider
import ru.ikom.localhostchat.di.features.FeaturesProvider

class DefaultAppContainer(
    private val application: Application
) : AppContainer {

    override val featuresProvider: FeaturesProvider by lazy {
        DefaultFeaturesProvider()
    }
}