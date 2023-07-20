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
    implementation(project(Module.designSystem))
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation(Test.junit)
    androidTestImplementation(Test.junitAndroid)
    androidTestImplementation(Test.espressoCore)

}