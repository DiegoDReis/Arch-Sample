plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

apply("$rootDir/plugins/android-common.gradle")

android {
    namespace = "com.sample.arch"

    defaultConfig {
        applicationId = "com.sample.arch"
    }
}

dependencies {

    implementation(Internal.coreKtx)
    implementation(Internal.appCompat)
    implementation(Internal.material)
    implementation(Internal.constraintLayout)
    implementation(Internal.fragmentKtx)
    testImplementation(Test.junit)
    androidTestImplementation(Test.junitAndroid)
    androidTestImplementation(Test.espressoCore)

}