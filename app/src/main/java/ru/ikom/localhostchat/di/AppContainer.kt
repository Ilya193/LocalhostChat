package ru.ikom.localhostchat.di

import ru.ikom.core.common.platform.PermissionsManager
import ru.ikom.localhostchat.di.features.FeaturesProvider

interface AppContainer {

    var permissionsManager: PermissionsManager

    val featuresProvider: FeaturesProvider
}