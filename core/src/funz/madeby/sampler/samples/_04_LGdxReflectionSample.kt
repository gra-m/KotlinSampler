package funz.madeby.sampler.samples

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.reflect.ClassReflection
import funz.madeby.sampler.common.SampleBase
import funz.madeby.sampler.utils.logger

class _04_LGdxReflectionSample : SampleBase() {
    companion object {
        @JvmStatic
        private val LOG = logger<_04_LGdxReflectionSample>()
    }



    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG

        debugReflection<Int>()
    }

    // reified == just specify type in <>
    private inline fun <reified T : Any> debugReflection() {
           val fields = ClassReflection.getDeclaredFields(T::class.java)
        val methods = ClassReflection.getDeclaredMethods(T::class.java)

        LOG.debug("Without loop: Reflected Class -> fields = $fields\nmethods = $methods")

        LOG.debug("Reflecting class = ${T::class.java.simpleName}\n #fields: ${fields.size} # methods: ${methods.size}\n" +
                "FIELDS:")

        for (i in fields.indices) {
            LOG.debug("\n${i+1} ${fields[i].name} || ${fields[i].type}")
        }
        LOG.debug("\n\nMETHODS:")

        for (i in methods.indices) {
            LOG.debug("\n${i+1} ${methods[i].name} || ${methods[i].returnType}  || ${methods[i].parameterTypes}")
        }
    }


}