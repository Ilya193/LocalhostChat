package ru.ikom.localhostchat.di.features

import ru.ikom.root.component.RootComponent

interface FeaturesProvider {

    fun provideRootComponentFactory(): RootComponent.Factory
}