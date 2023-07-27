plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply("$rootDir/plugins/android-common.gradle")

android {
    namespace = "com.sample.core.common"
}

dependencies {

    api(Internal.coreKtx)
    api(project(Module.designSystem))

    api(Test.junit)
    api(Test.mockk)
    api("androidx.arch.core:core-testing:2.2.0")

    androidTestApi(Test.junitAndroid)
    androidTestApi(Test.espressoCore)
}