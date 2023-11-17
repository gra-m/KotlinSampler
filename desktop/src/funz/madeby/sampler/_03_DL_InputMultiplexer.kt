//Created by Graham Duthie on 15/11/2023 12:06 -1h
package funz.madeby.sampler

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

fun main() {
    val config = Lwjgl3ApplicationConfiguration()
    config.setWindowSizeLimits(1080, 720, 1080, 720)

    Lwjgl3Application(_03_InputMultiplexerSample(), config)
}


