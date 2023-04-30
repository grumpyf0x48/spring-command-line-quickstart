plugins {
    application
    java
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.graalvm.buildtools.native")
}

group = "org.grumpyf0x48"
version = "0.1-SNAPSHOT"

val springBootPluginVersion: String by project
val picocliVersion: String by project
val lombokVersion: String by project
val junitVersion: String by project
val mockitoVersion: String by project

dependencies {
    implementation("org.springframework.boot:spring-boot-starter:${springBootPluginVersion}")
    implementation("info.picocli:picocli-spring-boot-starter:${picocliVersion}")
    implementation("info.picocli:picocli:${picocliVersion}")
    implementation("org.projectlombok:lombok:${lombokVersion}")
    annotationProcessor("info.picocli:picocli-codegen:${picocliVersion}")
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    testImplementation("org.springframework.boot:spring-boot-starter-test:${springBootPluginVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter:${junitVersion}")
    testImplementation("org.mockito:mockito-core:${mockitoVersion}")
}

application {
    mainClass.set("org.grumpyf0x48.spring_command_line_quickstart.Application")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

distributions {
    main {
        contents {
            from("${project.buildDir}/generated") {
                include("spring_command_line_quickstart")
                into("completion")
            }
        }
    }
    create("native") {
        contents {
            from("${project.buildDir}/generated") {
                include("spring_command_line_quickstart")
                into("completion")
            }
            from("${project.buildDir}/native/nativeCompile") {
                include("spring_command_line_quickstart")
                into("bin")
            }
        }
    }
}

val generateCompletion = task("generateCompletion", JavaExec::class) {
    setMain("picocli.AutoComplete")
    setClasspath(files(configurations.compileClasspath, configurations.annotationProcessor, sourceSets["main"].runtimeClasspath))
    doFirst {
        args("--force", "--name=spring_command_line_quickstart", "--completionScript=${project.buildDir}/generated/spring_command_line_quickstart", "org.grumpyf0x48.spring_command_line_quickstart.commands.Completion")
    }
}

tasks.distZip {
    dependsOn(generateCompletion)
}

tasks.distTar {
    dependsOn(generateCompletion)
}

tasks.getByName("nativeDistZip") {
    dependsOn(generateCompletion)
    dependsOn(tasks.nativeCompile)
}

tasks.getByName("nativeDistTar") {
    dependsOn(generateCompletion)
    dependsOn(tasks.nativeCompile)
}

tasks.getByName("installNativeDist") {
    dependsOn(generateCompletion)
    dependsOn(tasks.nativeCompile)
}

graalvmNative {
    toolchainDetection.set(false)
    binaries {
        all {
            resources.autodetect()
        }
        named("main") {
            imageName.set("spring_command_line_quickstart")
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}
