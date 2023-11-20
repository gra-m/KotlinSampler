//Created by Graham Duthie on 15/11/2023 12:11 -1h
package funz.madeby.sampler

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import funz.madeby.sampler.utils.clearScreen
import funz.madeby.sampler.utils.logger
import funz.madeby.sampler.utils.toInternalFile


class _07_SpriteBatchSample : ApplicationAdapter() {
    companion object {
        @JvmStatic
        private val LOG = logger<_07_SpriteBatchSample>()
    }

    private lateinit var camera: OrthographicCamera
    private lateinit var viewport: Viewport
    private lateinit var batch: SpriteBatch
    private lateinit var texture: Texture

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
        LOG.debug("create()")
        camera = OrthographicCamera()
        viewport = FitViewport(10.8f, 7.2f, camera)
        batch = SpriteBatch()
        texture = Texture("raw/character.png".toInternalFile())

    }

    override fun resize(width: Int, height: Int) {
        // if you have a viewport that has been instantiated, it still needs to be updated prior to use:
        viewport.update(width, height, true)
    }

    override fun render() {
        clearScreen()
        // Tell batch about camera position/rotation and zoom level
        batch.projectionMatrix = camera.combined
        batch.setColor(255f, 255f, 255f, 1f)


        batch.begin()
        draw()
        batch.end()

    }

    private fun draw() {
        val width = 1f
        val height = 1f
        val currentColor = batch.color

        LOG.debug(currentColor.toString())

        val newColor = Color.SALMON


        batch.draw(texture,
            1f, 1f,
            width/ 2f, height/2f,
            1f, 1f,
            1f, 1f,
            0f,
            0, 0,
            texture.width, texture.height,
            false, false
        )
        // scale 2x
        batch.draw(texture,
            4f, 2f,
            width/ 2f, height/2f,
            1f, 1f,
            2f, 2f,
            0f,
            0, 0,
            texture.width, texture.height,
            false, false
        )

        // Changing color
        batch.color = newColor
        batch.draw(texture,
            8f, 1f,
            width/ 2f, height/2f,
            1f, 1f,
            1f, 1f,
            0f,
            0, 0,
            texture.width, texture.height,
            false, false
        )

        batch.color =currentColor


    }

    override fun dispose() {
        LOG.debug("dispose()")
        batch.dispose()
        texture.dispose()
    }

}