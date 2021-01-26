plugins {
    kotlin("jvm") version "1.4.21"
}

group = "ru.ought"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val kotestVersion = "4.3.2"
    val atriumVersion = "0.15.0"
    implementation(kotlin("stdlib"))
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-extensions-spring:$kotestVersion")
    testImplementation("ch.tutteli.atrium:atrium-fluent-en_GB:$atriumVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
