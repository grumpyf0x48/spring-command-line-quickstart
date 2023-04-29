plugins {
    application
    java
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

version = "0.1-SNAPSHOT"

val springBootPluginVersion: String by project
val picocliSpringBootVersion: String by project
val lombokVersion: String by project
val junitVersion: String by project
val mockitoVersion: String by project

dependencies {
    implementation("org.springframework.boot:spring-boot-starter:${springBootPluginVersion}")
    implementation("info.picocli:picocli-spring-boot-starter:${picocliSpringBootVersion}")
    implementation("org.projectlombok:lombok:${lombokVersion}")
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    testImplementation("org.springframework.boot:spring-boot-starter-test:${springBootPluginVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter:${junitVersion}")
    testImplementation("org.mockito:mockito-core:${mockitoVersion}")
}

application {
    mainClass.set("org.grumpyf0x48.myapplication.Application")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<Test> {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}
