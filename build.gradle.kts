plugins {
    kotlin("jvm") version "1.4.21"
    application
}

val javaGroup = "ru.ought.magic_robot"
val javaMainClass = "MainKt"
group = javaGroup
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val kotestVersion = "4.3.2"
    val atriumVersion = "0.15.0"
    val jansiVersion = "2.2.0"
    val jlineVersion = "3.19.0"
    implementation(kotlin("stdlib"))
    implementation("org.fusesource.jansi:jansi:$jansiVersion")
    implementation("org.jline:jline:$jlineVersion")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-extensions-spring:$kotestVersion")
    testImplementation("ch.tutteli.atrium:atrium-fluent-en_GB:$atriumVersion")
}

application {
    mainClass.set(javaMainClass)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<Jar> {
    manifest {
        attributes(
            "Main-Class" to javaMainClass
        )
    }
}
