//Created by Graham Duthie on 15/11/2023 12:11 -1h
package funz.madeby.sampler.samples
import com.badlogic.gdx.Application
import com.badlogic.gdx.Application.LOG_DEBUG
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.Logger


class ModuleInfoSample : ApplicationAdapter() {
    companion object {
        @JvmStatic
        private val LOG = Logger(ModuleInfoSample::class.java.simpleName, LOG_DEBUG)
    }

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
        LOG.debug("app = ${Gdx.app}")
        LOG.debug("audio = ${Gdx.audio}")
        LOG.debug("input = ${Gdx.input}")
        LOG.debug("files = ${Gdx.files}")
        LOG.debug("net = ${Gdx.net}")
        LOG.debug("graphics = ${Gdx.graphics}")
    }


}