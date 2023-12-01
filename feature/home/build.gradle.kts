plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply("$rootDir/plugins/android-common.gradle")

android {
    namespace = "com.sample.feature.authentication"
}

dependencies {

    implementation(project(Module.commonAndroid))
    implementation(project(Module.designSystem))

    testImplementation(Test.junit)
    testImplementation(Test.mockk)
    testImplementation(Test.coreArch)

}