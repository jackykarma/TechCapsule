pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TechCapsule"
include(":app")

val dirArray = arrayOf("uilayer", "domainlayer", "datalayer", "foundation", "features")
dirArray.forEach { dirName ->
    val dir = File(rootProject.projectDir, dirName)
    if (dir.exists() && dir.isDirectory) {
        dir.listFiles()?.forEach { moduleDir ->
            if (moduleDir.isDirectory) {
                val modulePath = ":$dirName:${moduleDir.name}"
                include(modulePath)
                project(modulePath).projectDir = moduleDir
            }
        }
    }
}