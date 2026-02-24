plugins {
    java
    kotlin("jvm") version "2.3.0"
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

    implementation("com.pulumi:pulumi:1.21.0") // Pulumi SDK
    implementation("com.pulumi:github:6.12.1") // GitHub provider

    testImplementation(platform("org.junit:junit-bom:6.0.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}
