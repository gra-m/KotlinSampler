//Created by Graham Duthie on 15/11/2023 12:11 -1h
package `fun`.madeby.sampler

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch


class GdxSampler : ApplicationAdapter() {
    // batch cannot be created until framework is up and running, hence use of Kotlin's late init initializer
    // without this (libGDX in Java) is capable of having batch initialised in time not to get the UnsatisfiedLinkError
    // in Kotlin, this cannot be initialized in time.
    lateinit var batch: SpriteBatch
    lateinit var img: Texture

    override fun create() {
        batch = SpriteBatch()
        img = Texture("badlogic.jpg")
    }

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