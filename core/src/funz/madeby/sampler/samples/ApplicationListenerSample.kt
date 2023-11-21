//Created by Graham Duthie on 15/11/2023 12:11 -1h
package funz.madeby.sampler.samples

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import funz.madeby.sampler.common.SampleBase
import funz.madeby.sampler.utils.logger


class ApplicationListenerSample : SampleBase() {

    // Static method, available app wide if private is removed
    companion object {
        // @Jvm used to alter kotlin to apply Java standards, in below example Static Final
        @JvmStatic
        //private val LOG = Logger(ApplicationListenerSampler::class.java.simpleName, Logger.DEBUG)
        // THE above is long-winded for the creation of a gdx logger wherever you need it see utils generic function 'logger
        // private val LOG = logger(ApplicationListenerSampler::class.java)
        // finally using inline and reified:
        private val LOG = logger<ApplicationListenerSample>()

    }

    private var interruptRender = true
    override fun create() {
        // initialize game and load resources
        Gdx.app.logLevel = Application.LOG_DEBUG // activates debug level logs throughout app
        LOG.debug("create()")
    }

    override fun resize(width: Int, height: Int) {
        // set new screen size
        LOG.debug("resize()")
    }

    override fun render() {
        // called 60 *  per second, updates and renders game elements
        if (interruptRender) {
            LOG.debug("render()")
            interruptRender = false
        }
    }

    override fun pause() {
        // save game state when loses focus (out of window) or presumably backgrounded app?
        // this is not what is observed on closing window pause() then dispose() is called, this is prob a setting
        LOG.debug("pause()")
        interruptRender = true
    }

    override fun resume() {
        // back from pause()
        LOG.debug("resume()")
        interruptRender = true
    }

    override fun dispose() {
        // free resources and clean up
        LOG.debug("dispose()")
    }

}