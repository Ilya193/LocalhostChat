pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LocalhostChat"
include(":app")

include(":features")

include(":features:root")

include(":features:auth")
include(":features:auth:api")
include(":features:auth:impl")

include(":features:chat")
include(":features:chat:api")
include(":features:chat:impl")

include(":features:permissions")
include(":features:permissions:api")
include(":features:permissions:impl")

include(":core")

include(":core:common")

include(":core:chat-logic")

include(":core:voice-logic")

include(":core:datasources")