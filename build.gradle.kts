buildscript {
    val compose_ui_version by extra("1.4.0")
}
plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.library").version("7.4.1").apply(false)
    kotlin("multiplatform").version("1.8.0").apply(false)
    id("com.android.application") version "7.4.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.0" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}