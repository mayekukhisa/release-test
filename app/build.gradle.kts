plugins {
   id("com.android.application")
   kotlin("android")
}

kotlin {
   jvmToolchain(17)
}

android {
   namespace = "com.example"
   compileSdk = 34

   defaultConfig {
      applicationId = namespace
      minSdk = 24
      targetSdk = compileSdk
      versionCode = 1
      versionName = "0.1.0"

      testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

      vectorDrawables {
         useSupportLibrary = true
      }
   }

   buildTypes {
      getByName("release") {
         isMinifyEnabled = true
         proguardFiles(
            getDefaultProguardFile("proguard-android.txt"),
            "proguard-rules.pro",
         )
      }
   }

   buildFeatures {
      compose = true
   }

   composeOptions {
      kotlinCompilerExtensionVersion = "1.5.7"
   }

   packaging {
      resources {
         excludes += "/META-INF/{AL2.0,LGPL2.1}"
      }
   }
}

dependencies {
   val composeBom = platform("androidx.compose:compose-bom:2023.10.01")
   implementation(composeBom)
   androidTestImplementation(composeBom)

   implementation("androidx.activity:activity-compose:1.8.2")
   implementation("androidx.compose.material3:material3")
   implementation("androidx.compose.ui:ui")
   implementation("androidx.compose.ui:ui-tooling-preview")
   implementation("androidx.core:core-ktx:1.12.0")
   implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
   implementation("com.google.accompanist:accompanist-systemuicontroller:0.32.0")

   debugImplementation("androidx.compose.ui:ui-test-manifest")
   debugImplementation("androidx.compose.ui:ui-tooling")

   testImplementation("junit:junit:4.13.2")

   androidTestImplementation("androidx.compose.ui:ui-test-junit4")
   androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
   androidTestImplementation("androidx.test.ext:junit-ktx:1.1.5")
}
