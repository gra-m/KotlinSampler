//Created by Graham Duthie on 15/11/2023 12:11 -1h
package `fun`.madeby.sampler

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch


class GdxSampler : ApplicationAdapter() {
    var batch: SpriteBatch = SpriteBatch()
    var img: Texture = Texture("badlogic.jpg")

    override fun render() {
        Gdx.gl.glClearColor(1.0f, 0.0f, 0.0f, 1.0f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.begin()
        batch.draw(img, 0.0f, 0.0f)
        batch.end()

    }

    override fun dispose() {
        batch.dispose()
        img.dispose()
    }

}