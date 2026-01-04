package ru.ikom.localhostchat.di.features

import ru.ikom.auth.impl.component.defaultAuthComponentFactory
import ru.ikom.chat.impl.component.defaultChatComponentFactory
import ru.ikom.core.common.platform.PermissionsManager
import ru.ikom.localhostchat.di.core.CoreModule
import ru.ikom.root.component.RootComponent
import ru.ikom.root.component.defaultRootComponentFactory

class DefaultFeaturesProvider(
    private val coreModule: CoreModule,
    private val permissionsManager: PermissionsManager,
) : FeaturesProvider {

    override fun provideRootComponentFactory(): RootComponent.Factory =
        defaultRootComponentFactory(
            authComponentFactory = internalDefaultAuthComponentFactory(),
            chatComponentFactory = internalDefaultChatComponentFactory(),
        )

    private fun internalDefaultAuthComponentFactory() =
        defaultAuthComponentFactory(
            userRepository = coreModule.userLogicModule.userRepository
        )

    private fun internalDefaultChatComponentFactory() =
        defaultChatComponentFactory(
            permissionsManager = permissionsManager,
        )
}