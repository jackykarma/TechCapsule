import org.gradle.api.Project

fun Project.getIntProperty(key: String, defaultValue: Int): Int {
    return (properties[key] as? String)?.toIntOrNull() ?: defaultValue
}

extra.apply {
    // SDK 版本（可通过 gradle.properties 覆盖）
    set("compileSdkVer", getIntProperty("compileSdkVersion", 35))
    set("minSdkVer", getIntProperty("minSdkVersion", 21))
    set("targetSdkVer", getIntProperty("targetSdkVersion", 35))

    // App 版本
    // generation(0-9).majorVersion(0-99).minorVersion(0-999)
    set("mainAppVerCode", getIntProperty("mainAppVersionCode", 100000))
    set("mainAppVerName", properties["mainAppVersionName"] as? String ?: "1.00.000")
}