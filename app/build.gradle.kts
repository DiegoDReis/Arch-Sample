plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

apply("$rootDir/plugins/android-common.gradle")
apply("$rootDir/plugins/feature-dependencies.gradle")

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

    implementation("io.insert-koin:koin-android:3.5.0")

    testImplementation(Test.junit)
    androidTestImplementation(Test.junitAndroid)
    androidTestImplementation(Test.espressoCore)

}