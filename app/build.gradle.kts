plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

apply("$rootDir/plugins/android-common.gradle")
apply("$rootDir/plugins/feature-dependencies.gradle")
apply("$rootDir/plugins/core-dependencies.gradle")
apply("$rootDir/plugins/data-dependencies.gradle")

android {
    namespace = "com.sample.arch"

    defaultConfig {
        applicationId = "com.sample.arch"
    }
}

dependencies {

    implementation(Internal.appCompat)
    implementation(Internal.material)
    implementation(Internal.constraintLayout)
    implementation(Internal.fragmentKtx)
    implementation(project(Module.designSystem))

    testImplementation(Test.junit)
    androidTestImplementation(Test.junitAndroid)
    androidTestImplementation(Test.espressoCore)

}