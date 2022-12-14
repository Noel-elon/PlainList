pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "NoelCompose"
include(":app")
include(":core-network")
include(":core-database")
include(":core-common")
include(":core-data")
include(":feature-login")
include(":feature-search")
include(":core-navigation")
include(":core-designsystem")
