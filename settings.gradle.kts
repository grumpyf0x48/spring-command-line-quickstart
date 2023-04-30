pluginManagement {
    val springBootPluginId: String by settings
    val springDependencyPluginId: String by settings
    val nativeImagePluginId: String by settings

    val springBootPluginVersion: String by settings
    val springDependencyPluginVersion: String by settings
    val nativeImagePluginVersion: String by settings

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        id(springBootPluginId) version springBootPluginVersion
        id(springDependencyPluginId) version springDependencyPluginVersion
        id(nativeImagePluginId) version nativeImagePluginVersion
    }
}

rootProject.name = "myapplication"
