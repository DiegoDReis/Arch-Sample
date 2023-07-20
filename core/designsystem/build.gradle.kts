plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply("$rootDir/plugins/android-common.gradle")

android {
    namespace = "com.sample.designsystem"

}

dependencies {

    implementation(Internal.coreKtx)
    api(Internal.appCompat)
    api(Internal.material)
    api(Internal.constraintLayout)
    api(Internal.fragmentKtx)

}