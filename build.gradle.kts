subprojects {
    apply(from = "${rootProject.rootDir}/gradle/config.gradle.kts")
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.the.router) apply false // 插件声明，后续所有项目均可应用通过插件id应用插件
}

