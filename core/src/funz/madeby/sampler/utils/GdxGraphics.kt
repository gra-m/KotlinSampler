//Created by Graham Duthie on 17/11/2023 09:35
package funz.madeby.sampler.utils

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20

@JvmOverloads // makes java recognise these as overloaded 
fun clearScreen(color: Color = Color.BLACK) = clearScreen(0.0f, 0.0f, 0.0f, 1.0f)


fun clearScreen(red: Float, green: Float, blue: Float, alpha: Float) {
    Gdx.gl.glClearColor(red, green, blue, alpha)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
}