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

include(
    ":features:auth",
    ":features:auth:api",
    ":features:auth:impl"
)

include(
    ":features:chat",
    ":features:chat:api",
    ":features:chat:impl"
)

include(
    ":features:permissions",
    ":features:permissions:api",
    ":features:permissions:impl"
)

include(":core")

include(":core:common")

include(":core:chat-logic")

include(":core:voice-logic")

include(":core:datasources")

include(
    ":core:datasources:user",
    ":core:datasources:user:api",
    ":core:datasources:user:impl"
)

include(
    ":core:user-logic"
)
include(":core:user-logic:user-domain")
include(":core:user-logic:user-data")
