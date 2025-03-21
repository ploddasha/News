// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
	alias(libs.plugins.android.application) apply false
	alias(libs.plugins.jetbrains.kotlin.android) apply false

	kotlin("jvm") version "2.1.20"
	kotlin("plugin.serialization") version "2.1.20"

	alias(libs.plugins.compose.compiler) apply false
}