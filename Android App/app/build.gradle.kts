plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.Everness.cubeadventures"
    // Se cambió la sintaxis incorrecta por la estándar para que reconozca la versión 36
    compileSdk = 36

    signingConfigs {
        getByName("debug") {
            storeFile = file("C:\\Users\\admin\\cube-adventures-keys")
            storePassword = "12345678910"
            keyAlias = "Cube-Adventures"
            keyPassword = "12345678910"
        }
    }

    defaultConfig {
        applicationId = "com.Everness.cubeadventures"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    // Nota: Si te da error de "NDK not found", puedes borrar estas dos líneas de abajo
    ndkVersion = "30.0.14904198 rc1"
    buildToolsVersion = "36.0.0"

}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}