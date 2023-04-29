pluginManagement {
    val springBootPluginId: String by settings
    val springDependencyPluginId: String by settings

    val springBootPluginVersion: String by settings
    val springDependencyPluginVersion: String by settings

    repositories {
        mavenCentral()
    }

    plugins {
        id(springBootPluginId) version springBootPluginVersion
        id(springDependencyPluginId) version springDependencyPluginVersion
    }
}

rootProject.name = "spring-command-line-quickstart"
