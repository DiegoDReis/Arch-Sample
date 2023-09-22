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
    api(External.koinAndroid)
    api(Internal.coroutines)
    api(Internal.coroutinesCore)

    androidTestApi(Test.junitAndroid)
    androidTestApi(Test.espressoCore)
}