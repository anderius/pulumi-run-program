plugins {
    java
    kotlin("jvm") version "2.2.21"
    idea
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {

    implementation("com.pulumi:pulumi:1.17.1") // Pulumi SDK
    implementation("com.pulumi:github:6.9.1") // GitHub provider

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}