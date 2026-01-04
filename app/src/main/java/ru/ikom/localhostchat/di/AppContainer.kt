package ru.ikom.localhostchat.di

import ru.ikom.localhostchat.di.features.FeaturesProvider

interface AppContainer {

    val featuresProvider: FeaturesProvider
}