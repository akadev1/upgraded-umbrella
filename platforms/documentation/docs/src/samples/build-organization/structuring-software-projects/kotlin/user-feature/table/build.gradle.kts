plugins {
    id("com.example.java-library")
}

group = "${group}.user-feature"

dependencies {
    implementation(project(":data"))

    implementation("com.example.myproduct.state:application-state")
}
