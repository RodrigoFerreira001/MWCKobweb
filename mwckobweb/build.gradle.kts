import com.varabyte.kobweb.gradle.library.util.configAsKobwebLibrary
import kotlinx.html.HEAD
import kotlinx.html.link
import kotlinx.html.script
import kotlinx.html.unsafe

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.library)
}

kobweb {
    library {
        index {
            with(head) {
                addMaterialSymbolsDependencies()
                addGoogleFontsPreConnect()
                addMaterialWebScripts()
            }
        }
    }
}

kotlin {
    configAsKobwebLibrary()
    sourceSets {
        jsMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
        }
    }
}

fun ListProperty<HEAD.() -> Unit>.addMaterialSymbolsDependencies() {
    add {
        link {
            rel = "stylesheet"
            href =
                "https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&display=swap"
        }
    }
    add {
        link {
            rel = "stylesheet"
            href =
                "https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&display=swap"
        }
    }
    add {
        link {
            rel = "stylesheet"
            href =
                "https://fonts.googleapis.com/css2?family=Material+Symbols+Sharp:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&display=swap"
        }
    }
}

fun ListProperty<HEAD.() -> Unit>.addGoogleFontsPreConnect() {
    add {
        link {
            rel = "preconnect"
            href = "https://fonts.googleapis.com"
        }
    }
    add {
        link {
            rel = "preconnect"
            href = "https://fonts.gstatic.com"
        }
    }
}

fun ListProperty<HEAD.() -> Unit>.addMaterialWebScripts() {
    add {
        script {
            type = "importmap"
            unsafe {
                +"""
                {
                  "imports": {
                    "@material/web/": "https://esm.run/@material/web/"
                  }
                }
                """.trimIndent()
            }
        }
    }

    add {
        script {
            type = "module"
            unsafe {
                +"""
                import '@material/web/all.js';
                import {styles as typescaleStyles} from '@material/web/typography/md-typescale-styles.js';

                document.adoptedStyleSheets.push(typescaleStyles.styleSheet);
                """.trimIndent()
            }
        }
    }
}