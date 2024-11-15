import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.include

/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("buildlogic.java-application-conventions")
}


dependencies {
    implementation(project(":domain"))

    implementation("com.github.freva:ascii-table:1.8.0")
    implementation("org.apache.logging.log4j:log4j-core:2.23.1")
    implementation("com.athaydes.rawhttp:rawhttp-core:2.6.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.0")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.18.0")


}

application {
    // Define the main class for the application.
    mainClass = "com.jonathan.mybooklist.services.App"
}