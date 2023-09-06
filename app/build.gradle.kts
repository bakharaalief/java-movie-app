plugins {
    id("com.android.application")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.bakhdev.java_movie_app"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.bakhdev.java_movie_app"
        minSdk = 33
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        buildConfigField("String", "API_KEY", "\"fbb9572d11b5458ac98f02b84f2bafc4\"")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.airbnb.android:lottie:3.4.0")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.3.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

    implementation("com.google.dagger:hilt-android:2.44")
    annotationProcessor("com.google.dagger:hilt-compiler:2.44")

    implementation("io.reactivex.rxjava2:rxandroid:2.0.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.9")

    implementation("com.github.bumptech.glide:glide:4.16.0")
}