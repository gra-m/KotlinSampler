//Created by Graham Duthie on 15/11/2023 12:11 -1h
package `fun`.madeby.sampler

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.utils.Logger


class ApplicationListenerSampler : ApplicationListener {
    val LOG = Logger(ApplicationListenerSampler::class.java.simpleName, Logger.DEBUG)
    override fun create() {
        // initialize game and load resources
        LOG.debug("create()")
    }

    override fun resize(width: Int, height: Int) {
        // set new screen size
    }

    override fun render() {
        // called 60 *  per second, updates and renders game elements
    }

    override fun pause() {
        // save game state when loses focus (out of window) or presumably backgrounded app?
    }

    override fun resume() {
        // back from pause()
    }

    override fun dispose() {
        // free resources and clean up


    }

}