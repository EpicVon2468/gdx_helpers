@file:OptIn(ExperimentalKotlinGradlePluginApi::class)
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
	kotlin("jvm") version "2.3.0"
}

group = "io.github.epicvon2468.gdx_helpers"
version = "1.0.0"

kotlin {
	jvmToolchain(25)
	kotlinDaemonJvmArgs = listOf("-XX:+UseCompactObjectHeaders", "--enable-native-access=ALL-UNNAMED")
}

repositories {
	mavenCentral()
}

val ktxVersion = "1.13.1-rc1"
val gdxVersion = "1.14.0"

dependencies {
	api("io.github.libktx:ktx-actors:$ktxVersion")
	api("io.github.libktx:ktx-scene2d:$ktxVersion")
	api("io.github.libktx:ktx-assets:$ktxVersion")
	api("com.badlogicgames.gdx:gdx:$gdxVersion")
	compileOnly("org.jetbrains:annotations:26.0.2-1")
}