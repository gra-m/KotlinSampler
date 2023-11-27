//Created by Graham Duthie on 15/11/2023 12:11 -1h
package funz.madeby.sampler.samples

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import funz.madeby.sampler.common.SampleBase
import funz.madeby.sampler.utils.*

// fonts render @top left, so I took this opportunity to camera.setToOrtho(true) which makes everything render from top
//left
class _09_BitmapFontSample : SampleBase() {
    companion object {
        @JvmStatic
        private val LOG = logger<_09_BitmapFontSample>()
        private const val WIDTH = 1080f //1 pixel = 1 WU
        private const val HEIGHT = 720f
        
    }

    lateinit var camera: OrthographicCamera
    lateinit var viewport: Viewport
    lateinit var batch: SpriteBatch
    lateinit var effectsFont: BitmapFont
    lateinit var uiFont: BitmapFont
    lateinit var layout: GlyphLayout
    var setToOrtho = false

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
        LOG.debug("create()")
        camera = OrthographicCamera()
        camera.setToOrtho(setToOrtho)
        viewport = FitViewport(1080f, 720f, camera)
        batch = SpriteBatch()
        //font = BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"))
        effectsFont = BitmapFont("fonts/effect_font_32.fnt".toInternalFile())
        uiFont = BitmapFont("fonts/ui_font_32.fnt".toInternalFile())
        layout = GlyphLayout()
    }

    override fun resize(width: Int, height: Int) {
        // if you have a viewport that has been instantiated, it still needs to be updated prior to use:
        viewport.update(width, height, true)
    }

    override fun render() {
        clearScreen()
        batch.projectionMatrix = camera.combined
        batch.use { draw() }

    }

    private fun draw() {
        // set up markup enabled on  effects font
        effectsFont.data.markupEnabled = true
        val welcomeTxt = "[#FF0000]HELLO, WITHOUT [GREEN]USING LAYOUT!"
        val moreTxt = "COMPONENT CLASS USED.."

        layout.setText(uiFont, welcomeTxt)

        effectsFont.draw(batch, welcomeTxt, WIDTH/2, HEIGHT/3, 500f,  Align.center, true)

        uiFont.draw(batch, layout, (WIDTH - layout.width) / 2, (HEIGHT - layout.height) / 2 )

        layout.setText(effectsFont, moreTxt)

        val renderCentral = MainScreenRenderCentral(layout)

        effectsFont.draw(batch, layout, renderCentral.x, renderCentral.y)

    }
    

    override fun dispose() {
        LOG.debug("dispose()")
        batch.dispose()
        effectsFont.dispose()
        uiFont.dispose()
    }

}