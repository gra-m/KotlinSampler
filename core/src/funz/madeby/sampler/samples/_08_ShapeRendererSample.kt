//Created by Graham Duthie on 21/11/2023 14:16
package funz.madeby.sampler.samples

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import funz.madeby.sampler.common.SampleBase
import funz.madeby.sampler.utils.clearScreen
import funz.madeby.sampler.utils.logger

class _08_ShapeRendererSample : SampleBase() {

    companion object {
        @JvmStatic
        private val log = logger<_08_ShapeRendererSample>()
        private const val WORLD_WIDTH = 40f
        private const val WORLD_HEIGHT = 20f
    }

    // lateinit == delayed init until framework is up and running
    private lateinit var camera: OrthographicCamera
    private lateinit var viewport: Viewport
    private lateinit var renderer: ShapeRenderer
    private var centerCamera = true
    private  var drawGrid = true
    private  var drawCircles = true
    private  var drawRectangles = true
    private  var drawPoints = true


    override fun create() {
        camera = OrthographicCamera()
        viewport = FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera)
        renderer = ShapeRenderer()

        // SampleBase implements InputProcessor
        Gdx.input.inputProcessor = this
    }

    override fun render() {
        clearScreen()
        setRendererProjectionMatrix()

        if(drawGrid)
            drawGrid()
        if(drawCircles)
            drawCircles()
        if(drawRectangles)
            drawRectangles()
        if(drawPoints)
            drawPoints()
    }

    private fun drawPoints() {
        renderer.color = Color.GRAY

        renderer.begin(ShapeRenderer.ShapeType.Filled)

        renderer.point(3f, 3f, 0f)
        renderer.color = Color.FIREBRICK
        renderer.point(4f, 5f, 0f)

        renderer.color = Color.GOLD
        renderer.point(5f, 7f, 0f)
        renderer.point(17f, 1f, 0f)
        renderer.end()

        renderer.begin(ShapeRenderer.ShapeType.Line)
        renderer.color = Color.FOREST
        renderer.x(-10f, -5f, 5f)
        renderer.end()
    }

    private fun drawRectangles() {
        renderer.color = Color.GOLD

        renderer.begin(ShapeRenderer.ShapeType.Filled)

        renderer.rect(3f, 3f, 1f, 1f)
        renderer.color = Color.GOLDENROD
        renderer.rect(4f, 5f, 1f, 1f)
        renderer.color = Color.FIREBRICK
        renderer.rect(5f, 7f, 1f, 1f)
        renderer.rect(17f, 1f, 1f, 1f)
        renderer.end()
    }
    private fun drawCircles() {
       renderer.color = Color.GOLD

       renderer.begin(ShapeRenderer.ShapeType.Filled)

        renderer.circle(1f, 1f, 1f, 40)
        renderer.color = Color.GOLDENROD
        renderer.circle(2f, 2f, 1f)
        renderer.color = Color.FIREBRICK
        renderer.circle(3f, 3f, 1f, 30)
        renderer.circle(19f, 1f, 1f)
       renderer.end()
    }

    private fun drawGrid() {
        val width = WORLD_WIDTH.toInt()
        val height = WORLD_HEIGHT.toInt()
        renderer.color = Color.WHITE

        // -width to width when camera is not centered -width is from 0,0 in the center of the screen
        renderer.begin(ShapeRenderer.ShapeType.Line)
        // horizontals first two co-ordinates == start of line 2nd two end of line
        for (y in -height  until height) {
            renderer.line(-width.toFloat(), y.toFloat(), width.toFloat(), y.toFloat())
        }
        // verticals
        for (x in -width until width) {
            renderer.line(x.toFloat(), -height.toFloat(), x.toFloat(), height.toFloat())
        }
        renderer.color = Color.RED
        renderer.line(-width.toFloat(), 0f, width.toFloat(), 0f)
        renderer.line(0f, -height.toFloat(), 0f, height.toFloat())

        renderer.color = Color.MAGENTA
        renderer.line(0f, 0f, width.toFloat(), height.toFloat())
        //?? showing only when camera centered == strange
        renderer.color = Color.CYAN
        renderer.line(0f, height.toFloat(), width.toFloat(), 0f)

        renderer.end()
    }

    override fun keyDown(keycode: Int): Boolean {
        when (keycode) {
            Input.Keys.G -> drawGrid = !drawGrid
            Input.Keys.C -> drawCircles = !drawCircles
            Input.Keys.R -> drawRectangles = !drawRectangles
            Input.Keys.P -> drawPoints = !drawPoints
        }
       return true
    }

    //only added so render reads like a to-do list
    private fun setRendererProjectionMatrix() {
      // like SpriteBatch renderer has to have its projection matrix set
      renderer.projectionMatrix = camera.combined
    }

    override fun resize(width: Int, height: Int) {
        dontForgetToUpdateViewport(width, height)
    }

    private fun dontForgetToUpdateViewport(width: Int, height: Int) {
        // really, you will wonder why nothing is rendering and blame something more complex dot. ;) note camera is not centered
        viewport.update(width, height, centerCamera)
    }

    override fun dispose() {
       renderer.dispose()
    }
}