//Created by Graham Duthie on 15/11/2023 12:11 -1h
package funz.madeby.sampler

import com.badlogic.gdx.Application
import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import funz.madeby.sampler.utils.clearScreen
import funz.madeby.sampler.utils.isKeyPressed
import funz.madeby.sampler.utils.logger
import funz.madeby.sampler.utils.toInternalFile


class _05_OrthographicCameraSample : ApplicationAdapter() {
    companion object {
        @JvmStatic
        private val LOG = logger<_05_OrthographicCameraSample>()
        // could also be outside of companion object but not as a constant with Kotlin marking of 'const'
        private const val WORLD_WIDTH = 10.8f
        private const val WORLD_HEIGHT = 7.2f
        private const val CAMERA_SPEED = 2.0f
        private const val CAMERA_ZOOM_SPEED = 2.0f
    }


    lateinit var camera: OrthographicCamera
    lateinit var viewport: Viewport
    lateinit var batch: SpriteBatch
    lateinit var texture: Texture
    var limiter = 0

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
        LOG.debug("create()")

        camera = OrthographicCamera()
        // This set up is easier for menu overlays:
        camera.setToOrtho(true)
        viewport = FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera)
        batch = SpriteBatch()
        texture = Texture("raw/level-bg.png".toInternalFile())

    }

    override fun resize(width: Int, height: Int) {
        // if you have a viewport that has been instantiated, it still needs to be updated prior to use:
        viewport.update(width, height, true)
    }

    override fun render() {
        clearScreen()
        queryInput()
        // camera position, zoom and rotation obtained by Spritebatch from camera
        batch.projectionMatrix = camera.combined

        batch.begin()
        draw()
        batch.end()

    }

    private fun queryInput() {
        // deltaTime here is independent of devices with their different frame rates (how it was obtained
        // automatically in Java examples)
        val deltaTime = Gdx.graphics.deltaTime

        when{
            Input.Keys.LEFT.isKeyPressed() -> camera.position.x -= CAMERA_SPEED * deltaTime
            Input.Keys.RIGHT.isKeyPressed() -> camera.position.x += CAMERA_SPEED * deltaTime
            Input.Keys.UP.isKeyPressed() -> camera.position.y += CAMERA_SPEED * deltaTime
            Input.Keys.DOWN.isKeyPressed() -> camera.position.y -= CAMERA_SPEED * deltaTime
            Input.Keys.PAGE_UP.isKeyPressed() -> camera.zoom -= CAMERA_ZOOM_SPEED * deltaTime
            Input.Keys.PAGE_DOWN.isKeyPressed() -> camera.zoom += CAMERA_ZOOM_SPEED * deltaTime
            Input.Keys.ENTER.isKeyPressed() -> {
                LOG.debug("position = ${camera.position}\n zoom= ${camera.zoom}")
            }
            else -> {
                limiter++
                if (limiter % 60 == 0)
                LOG.debug("no keys pressed -> this output is limited to 1/60th")
        }
        }
        camera.update()
    }

    private fun draw() {
        batch.draw(texture, 0f, 0f, WORLD_WIDTH, WORLD_HEIGHT)

    }

    override fun dispose() {
        LOG.debug("dispose()")
        batch.dispose()
        texture.dispose()
    }

}