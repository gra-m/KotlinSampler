//Created by Graham Duthie on 15/11/2023 12:11 -1h
package `fun`.madeby.sampler

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.Logger


class ApplicationListenerSampler : ApplicationListener {
    val LOG = Logger(ApplicationListenerSampler::class.java.simpleName, Logger.DEBUG)
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