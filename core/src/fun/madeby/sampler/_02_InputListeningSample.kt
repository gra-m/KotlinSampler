//Created by Graham Duthie on 15/11/2023 12:11 -1h
package `fun`.madeby.sampler

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputProcessor
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import `fun`.madeby.sampler.utils.clearScreen
import `fun`.madeby.sampler.utils.logger
import `fun`.madeby.sampler.utils.toInternalFile

// Import tagging
//import com.badlogic.gdx.utils.Array as GdxArray

// type aliasing within actual file or elsewhere for use throughout == put the below in a kotlin file named GdxArray
typealias GdxArray<T> = com.badlogic.gdx.utils.Array<T>

class _02_InputListeningSample : ApplicationAdapter(), InputProcessor {
    companion object {
        @JvmStatic
        private val LOG = logger<_02_InputListeningSample>()
    }

    lateinit var camera: OrthographicCamera
    lateinit var viewport: Viewport
    lateinit var batch: SpriteBatch
    lateinit var font: BitmapFont

    private val maxMessageCount = 15
    private val messages = GdxArray<String>()

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
        LOG.debug("create()")
        camera = OrthographicCamera()
        viewport = FitViewport(1080f, 720f, camera)
        batch = SpriteBatch()
        //font = BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"))
        font = BitmapFont("fonts/oswald-32.fnt".toInternalFile())
        Gdx.input.inputProcessor = this

    }

    override fun resize(width: Int, height: Int) {
        // if you have a viewport that has been instantiated, it still needs to be updated prior to use:
        viewport.update(width, height, true)
    }

    override fun render() {
        clearScreen()
        batch.projectionMatrix = camera.combined

        batch.begin()
        draw()
        batch.end()

    }

    private fun draw() {
        var increment = 35f
        var offset = 35f
        for (str in messages) {
            font.draw(batch, str, 20f, 720f - offset)
            offset += increment
        }
    }

    override fun dispose() {
        batch.dispose()
        font.dispose()
    }

    private fun addMessage(message: String) {
            messages.add(message)
        if (messages.size >= maxMessageCount)
            messages.removeIndex(0)

    }

    override fun keyDown(keycode: Int): Boolean {
        val message = "keyDown() keycode = $keycode"
        LOG.debug(message)
        addMessage(message)
        return true
    }

    override fun keyUp(keycode: Int): Boolean {
        val message = "keyUp() keycode = $keycode"
        LOG.debug(message)
        addMessage(message)
        return true
    }

    override fun keyTyped(character: Char): Boolean {
        val message = "keyTyped() keycode = $character"
        LOG.debug(message)
        addMessage(message)
        return true
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        val message = "touchDown() screenX = $screenX screenY = $screenY pointer= $pointer button = $button"
        LOG.debug(message)
        addMessage(message)
        return true
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        val message = "touchUp() screenX = $screenX screenY = $screenY pointer= $pointer button = $button"
        LOG.debug(message)
        addMessage(message)
        return true
    }

    override fun touchCancelled(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        val message = "touchCancelled() screenX = $screenX screenY = $screenY pointer= $pointer button = $button"
        LOG.debug(message)
        addMessage(message)
        return true
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        val message = "touchDragged() screenX = $screenX screenY = $screenY pointer= $pointer"
        LOG.debug(message)
        addMessage(message)
        return true
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
        val message = "mouseMoved() screenX = $screenX screenY = $screenY"
        LOG.debug(message)
        addMessage(message)
        return true
    }

    override fun scrolled(amountX: Float, amountY: Float): Boolean {
        val message = "scrolled() amountX = $amountX amountY = $amountY"
        LOG.debug(message)
        addMessage(message)
        return true
    }
}