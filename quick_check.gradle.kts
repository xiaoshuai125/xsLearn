import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "2.3.0"
}

repositories {
    mavenCentral()
}

dependencies {
    // 我们不需要任何依赖，只需要编译语法检查
}

kotlin {
    jvmToolchain(17)
}

// 指定源文件
sourceSets {
    main {
        kotlin.srcDir(
            "composeApp/src/commonMain/kotlin"
        )
    }
}

tasks.register("quickCheck") {
    dependsOn("compileKotlin")
    doLast {
        println("✅ Kotlin syntax check passed!")
    }
}
