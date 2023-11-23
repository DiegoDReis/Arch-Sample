plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies{
    implementation(Internal.coroutinesCore)

    testImplementation(Test.mockk)
    testImplementation(kotlin("test"))
}