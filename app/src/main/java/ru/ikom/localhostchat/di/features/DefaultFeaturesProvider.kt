package ru.ikom.localhostchat.di.features

import ru.ikom.chat.impl.component.defaultChatComponentFactory
import ru.ikom.root.component.RootComponent
import ru.ikom.root.component.defaultRootComponentFactory

class DefaultFeaturesProvider : FeaturesProvider {

    override fun provideRootComponentFactory(): RootComponent.Factory =
        defaultRootComponentFactory(
            chatComponentFactory = internalDefaultChatComponentFactory(),
        )

    private fun internalDefaultChatComponentFactory() =
        defaultChatComponentFactory()
}