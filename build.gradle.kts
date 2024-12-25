plugins {
    id("java")
}

group = "hexlet.code"
version = "1.0"

tasks.jar {
    manifest {
        attributes["Main-Class"] = "hexlet.code.SantaAnimation"
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}