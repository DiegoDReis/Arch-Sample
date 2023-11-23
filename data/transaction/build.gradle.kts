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

    implementation(Internal.roomRuntime)
    implementation(Internal.roomKotlin)
    implementation(project(Module.commonAndroid))
    implementation(project(Module.transactionDomain))

    kapt(Internal.roomCompiler)

    testImplementation(Test.mockk)
    testImplementation(Test.junitAndroid)
    testImplementation(Test.coreArchAndroidTest)
}