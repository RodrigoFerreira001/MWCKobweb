import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
}

kobweb {
    app {
        index {
            with(head) {
                add {
                    link {
                        rel = "stylesheet"
                        href = "https://fonts.googleapis.com/css2?family=Antic+Didone&display=swap"
                    }
                }

                add {
                    link {
                        rel = "stylesheet"
                        href = "https://fonts.googleapis.com/css2?family=Jost:ital,wght@0,100..900;1,100..900&display=swap"
                    }
                }
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("sample")

    sourceSets {
        jsMain.dependencies {
            implementation(project(":kobweb-material"))

            implementation(libs.compose.runtime)
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
        }
    }
}
