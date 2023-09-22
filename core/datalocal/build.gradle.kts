plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

apply("$rootDir/plugins/android-common.gradle")
apply("$rootDir/plugins/data-dependencies.gradle")

android {
    namespace = "com.sample.arch.datalocal"
}

dependencies {
    implementation(Internal.roomRuntime)
    implementation(Internal.roomKotlin)
    implementation(project(Module.commonAndroid))

    kapt(Internal.roomCompiler)
}