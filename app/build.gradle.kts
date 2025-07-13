plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("therouter") // 应用the router插件
    kotlin("kapt") // 启用kapt 插件功能
}

android {
    namespace = "com.jacky.techcapsule"
    compileSdk = project.extra["compileSdkVer"] as Int
    defaultConfig {
        minSdk = project.extra["minSdkVer"] as Int
        targetSdk = project.extra["targetSdkVer"] as Int
        versionCode = project.extra["mainAppVerCode"] as Int
        versionName = project.extra["mainAppVerName"] as String

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {  // 创建release签名配置
            storeFile = file("/Users/limao/Jacky/androidprojects/jacky")
            storePassword = "00000000"
            keyAlias = "jacky"
            keyPassword = "00000000"
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
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

    // the router插件API库
    implementation(libs.the.router)
    // the router插件注解解析器
    kapt(libs.the.router.apt)
}