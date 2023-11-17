//Created by Graham Duthie on 15/11/2023 12:11 -1h
package `fun`.madeby.sampler

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import `fun`.madeby.sampler.utils.clearScreen
import `fun`.madeby.sampler.utils.logger
import `fun`.madeby.sampler.utils.toInternalFile


class _01_InputPollingSample : ApplicationAdapter() {
    companion object {
        @JvmStatic
        private val LOG = logger<_01_InputPollingSample>()
    }

    lateinit var camera: OrthographicCamera
    lateinit var viewport: Viewport
    lateinit var batch: SpriteBatch
    lateinit var font: BitmapFont

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
        LOG.debug("create()")
        camera = OrthographicCamera()
        viewport = FitViewport(1080f, 720f, camera)
        batch = SpriteBatch()
        //font = BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"))
        font = BitmapFont("fonts/oswald-32.fnt".toInternalFile())

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
        val mouseX =  Gdx.input.x
        val mouseY =  Gdx.input.y

        val leftPressed = Gdx.input.isButtonPressed(Input.Buttons.LEFT)
        val rightPressed = Gdx.input.isButtonPressed(Input.Buttons.RIGHT)
        val rightPressedString = if (rightPressed) "rightPressed" else "rightNotPressed"
        val wPressedString = if (Gdx.input.isKeyPressed(Input.Keys.W)) "W pressed" else "W not pressed"
        val sPressedString = if (Gdx.input.isKeyPressed(Input.Keys.S)) "S pressed" else "S not pressed"


        font.draw(batch, "Mouse x = $mouseX, y = $mouseY", 20f, 720f - 20f)
        font.draw(batch, "leftPressed = $leftPressed, $rightPressedString", 20f, 720f - 60f)
        font.draw(batch, "$wPressedString, $sPressedString", 20f, 720f - 100f)
    }

    override fun dispose() {
        batch.dispose()
        font.dispose()
    }

}