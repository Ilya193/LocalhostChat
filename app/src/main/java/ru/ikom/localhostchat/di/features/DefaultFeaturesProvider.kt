package ru.ikom.localhostchat.di.features

import ru.ikom.auth.impl.component.defaultAuthComponentFactory
import ru.ikom.chat.impl.component.defaultChatComponentFactory
import ru.ikom.root.component.RootComponent
import ru.ikom.root.component.defaultRootComponentFactory

class DefaultFeaturesProvider : FeaturesProvider {

    override fun provideRootComponentFactory(): RootComponent.Factory =
        defaultRootComponentFactory(
            authComponentFactory = internalDefaultAuthComponentFactory(),
            chatComponentFactory = internalDefaultChatComponentFactory(),
        )

    private fun internalDefaultAuthComponentFactory() =
        defaultAuthComponentFactory()

    private fun internalDefaultChatComponentFactory() =
        defaultChatComponentFactory()
}