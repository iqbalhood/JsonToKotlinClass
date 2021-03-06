package wu.seal.jsontokotlin

import com.intellij.ide.util.PropertiesComponent
import wu.seal.jsontokotlin.test.TestConfig

/**
 * Config Manager
 * Created by Seal.Wu on 2018/2/7.
 */
object ConfigManager : IConfigManager {

    private const val INDENT_KEY = "json-to-kotlin-class-indent-space-number"
    private const val ENABLE_MAP_TYP_KEY = "json-to-kotlin-class-enable-map-type"
    private const val ENABLE_AUTO_REFORMAT = "json-to-kotlin-class-enable-auto-reformat"
    private const val ENABLE_MINIMAL_ANNOTATION = "json-to-kotlin-class-enable-minimal-annotation"

    var indent: Int
        get() = if (TestConfig.isTestModel) TestConfig.indent else PropertiesComponent.getInstance().getInt(
            INDENT_KEY,
            4
        )
        set(value) = if (TestConfig.isTestModel) {
            TestConfig.indent = value
        } else PropertiesComponent.getInstance().setValue(INDENT_KEY, value, 4)

    var enableMapType: Boolean
        get() = if (TestConfig.isTestModel) TestConfig.enableMapType else PropertiesComponent.getInstance().getBoolean(
            ENABLE_MAP_TYP_KEY,
            false
        )
        set(value) = if (TestConfig.isTestModel) {
            TestConfig.enableMapType = value
        } else PropertiesComponent.getInstance().setValue(ENABLE_MAP_TYP_KEY, value, false)

    var enableAutoReformat: Boolean
        get() = (TestConfig.isTestModel && TestConfig.enableAutoReformat)
                || PropertiesComponent.getInstance().getBoolean(ENABLE_AUTO_REFORMAT, true)
        set(value) = if (TestConfig.isTestModel) {
            TestConfig.enableAutoReformat = value
        } else PropertiesComponent.getInstance().setValue(ENABLE_AUTO_REFORMAT, value, true)

    var enableMinimalAnnotation: Boolean
        get() = if (TestConfig.isTestModel) {
            TestConfig.enableMinimalAnnotation
        } else {
            PropertiesComponent.getInstance().getBoolean(ENABLE_MINIMAL_ANNOTATION, false)
        }
        set(value) {
            if (TestConfig.isTestModel) {
                TestConfig.enableMinimalAnnotation = value
            } else {
                PropertiesComponent.getInstance().setValue(ENABLE_MINIMAL_ANNOTATION, value, false)
            }
        }
}