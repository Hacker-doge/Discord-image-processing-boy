plugins {
    kotlin("jvm") version "2.2.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

configurations.all {
    resolutionStrategy {
        force("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
    }
}


repositories {
    mavenCentral()
    // Kord Snapshot Repositories (optional, choose one of these):
    maven("https://repo.kord.dev/snapshots")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("ai.koog:koog-agents:0.6.0")
    implementation("io.github.cdimascio:java-dotenv:5.2.2")
    implementation("dev.kord:kord-core:0.17.0")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.7.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(24)
}