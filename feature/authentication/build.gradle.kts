plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply("$rootDir/plugins/android-common.gradle")

android {
    namespace = "com.sample.feature.authentication"
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