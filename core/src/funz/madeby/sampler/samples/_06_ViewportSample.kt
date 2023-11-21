//Created by Graham Duthie on 15/11/2023 12:11 -1h
package funz.madeby.sampler.samples

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ArrayMap
import com.badlogic.gdx.utils.viewport.*
import funz.madeby.sampler.common.SampleBase
import funz.madeby.sampler.utils.*

/* Viewports controls the strategy for scaling game world to screen.
Built in Strategies to handle multiple resolutions.
This example is not v. useful as it is not in the expected JFrame used in the original videos, this is the only one
that suffers though..*/
class _06_ViewportSample : SampleBase() {
    companion object {
        @JvmStatic
        private val LOG = logger<_06_ViewportSample>()
        // could also be outside of companion object but not as a constant with Kotlin marking of 'const'
        private const val WORLD_WIDTH = 1080f // still world units and NOT pixels just on WU per pixel for this.
        private const val WORLD_HEIGHT = 720f
    }


    lateinit var camera: OrthographicCamera
    lateinit var currentViewport: Viewport
    lateinit var batch: SpriteBatch
    lateinit var font: BitmapFont
    lateinit var texture: Texture

    private val viewports = ArrayMap<String, Viewport>()
    private var  currentViewportIndex = -1
    private var currentViewportName = ""


    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
        LOG.debug("create()")

        camera = OrthographicCamera()
        // This set up is easier for menu overlays as it renders from top left (flips bground):
        //camera.setToOrtho(true)
        batch = SpriteBatch()
        font = BitmapFont("fonts/oswald-32.fnt".toInternalFile())
        texture = Texture("raw/level-bg.png".toInternalFile())

        Gdx.input.inputProcessor = this
        createViewports()
        selectNextViewport() // -> call path to queryInput()
    }

    private fun createViewports() {
        viewports.put(StretchViewport::class.java.simpleName, StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera))
        viewports.put(FitViewport::class.java.simpleName, FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera))
        viewports.put(FillViewport::class.java.simpleName, FillViewport(WORLD_WIDTH, WORLD_HEIGHT, camera))
        viewports.put(ExtendViewport::class.java.simpleName, ExtendViewport(WORLD_WIDTH, WORLD_HEIGHT, camera))
        viewports.put(ScreenViewport::class.java.simpleName, ScreenViewport(camera))
        
    }

    private fun selectNextViewport() {
        currentViewportIndex = (currentViewportIndex + 1 ) % viewports.size

        currentViewport = viewports.getValueAt(currentViewportIndex)
        resize(Gdx.graphics.width, Gdx.graphics.height)
        currentViewportName = viewports.getKeyAt(currentViewportIndex)

        LOG.debug("Selected $currentViewportName at index $currentViewportIndex")

    }
    // replaced with input
    private fun queryInput() {
        when{
            Input.Keys.PAGE_UP.isKeyPressed() -> {
                LOG.debug("Aaaaargh... called from renderrrrr....")
                selectNextViewport()}
            Input.Keys.PAGE_DOWN.isKeyPressed() -> LOG.debug("PAGE_DOWN")
            }

        camera.update()
        }

    override fun resize(width: Int, height: Int) {
        // if you have a viewport that has been instantiated, it still needs to be updated prior to use:
        currentViewport.update(width, height, true)
    }

    override fun render() {
        clearScreen()
        //queryInput()
        // camera position, zoom and rotation obtained by Spritebatch from camera
        batch.projectionMatrix = camera.combined
        batch.use { draw() }


    }

    private fun draw() {
        var incomplete = "for full demonstration of these\nlook at the java version"
        batch.draw(texture, 0f, 0f, WORLD_WIDTH, WORLD_HEIGHT)

        font.draw(batch, "$currentViewportName,\n$incomplete", 50f, 200f)

    }

   // Overriding all of the other methods as stubs in my own interface, so the rest of the methods are not shown here
    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        selectNextViewport()
        return true
    }

    override fun dispose() {
        LOG.debug("dispose()")
        batch.dispose()
        texture.dispose()
    }



}