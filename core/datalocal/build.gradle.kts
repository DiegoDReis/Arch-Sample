plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

apply("$rootDir/plugins/android-common.gradle")

android {
    namespace = "com.sample.arch.datalocal"
}

dependencies {

    api(Internal.coreKtx)
    api(Internal.roomRuntime)
    api(Internal.roomKotlin)
    api(Internal.coroutines)
    api(Internal.coroutinesCore)

    kapt(Internal.roomCompiler)
}