import java.util.Properties

plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.jetbrains.kotlin.android)

	//kotlin("plugin.serialization") version "2.1.20" apply false

	alias(libs.plugins.compose.compiler)

}

android {
	namespace = "ru.plodushcheva.news"
	compileSdk = 35

	defaultConfig {
		applicationId = "ru.plodushcheva.news"
		minSdk = 26
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}

		//load the values from .properties file
		val keystoreFile = project.rootProject.file("apikey.properties")
		val properties = Properties()
		properties.load(keystoreFile.inputStream())

		//return empty key in case something goes wrong
		val apiKey = properties.getProperty("NEWS_API_KEY") ?: ""

		buildConfigField(
			type = "String",
			name = "NEWS_API_KEY",
			value = apiKey
		)
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
	buildFeatures {
		compose = true
	}
	buildFeatures {
		buildConfig = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.1"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.graphics)
	implementation(libs.androidx.ui.tooling.preview)
	implementation(libs.androidx.material3)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)
	debugImplementation(libs.androidx.ui.tooling)
	debugImplementation(libs.androidx.ui.test.manifest)

	//retrofit
	implementation(libs.retrofit)
	implementation(libs.converter.name)
	implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

	//serialisation
	implementation(libs.kotlinx.serialization.json)
	implementation(libs.gson)

	//navigation
	implementation("androidx.navigation:navigation-compose:2.8.9")

	//koin
	implementation("io.insert-koin:koin-core:3.5.6")
	implementation("io.insert-koin:koin-android:3.5.6")
	implementation("io.insert-koin:koin-core-coroutines:3.5.6")
	implementation("androidx.startup:startup-runtime:1.1.1")
	//implementation("io.insert-koin:koin-compose-viewmodel:3.5.6")
	implementation("io.insert-koin:koin-androidx-compose:3.5.6")

}