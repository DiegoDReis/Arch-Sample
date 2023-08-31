plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

apply("$rootDir/plugins/android-common.gradle")

android {
    namespace = "com.sample.data.home"
}

dependencies {

    implementation(project(Module.dataLocal))

    kapt(Internal.roomCompiler)
}