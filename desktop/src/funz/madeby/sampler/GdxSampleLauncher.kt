//Created by Graham Duthie on 17/11/2023 11:12
package funz.madeby.sampler

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import funz.madeby.sampler.common.SampleFactory

class GdxSampleLauncher {
    private var running = true
    val config = Lwjgl3ApplicationConfiguration()

    init {
        config.setWindowedMode(1080, 720)
        var count = 0

        while(running) {
            var welcome = if(count == 0) "Which sample do you want to run?" else "Want to run another sample?"
            println(welcome)
            println("\n1.InputPolling\n2.InputListening\n3.InputMultiplexer[press some keys, play with true/false" +
                    "\n4.LGdxReflectionSample[MethodsAndFieldsOfActiveClass\n5.OrthographicCameraSample" +
                    "\n6.ViewportSample\n7.SpriteBatchSample\n8.ShapeRendererSample\n9.BitmapFontSample" +
                    "\n10.ApplicationListenerSample[CallOrder]" +
                    "\n11.ModuleInfoSample[The Interfaces used by LibGdx]\n12.GdxGeneratedSample\n0.exit")
            count++
            val choice:Int =  readLine()!!.toInt()

            when(choice) {
                1 -> runSample("_01_InputPollingSample")
                2 -> runSample("_02_InputListeningSample")
                3 -> runSample("_03_InputMultiplexerSample")
                4 -> runSample("_04_LGdxReflectionSample")
                5 -> runSample("_05_OrthographicCameraSample")
                6 -> runSample("_06_ViewportSample")
                7 -> runSample("_07_SpriteBatchSample")
                8 -> runSample("_08_ShapeRendererSample")
                9 -> runSample("_09_BitmapFontSample")
                10 -> runSample("ApplicationListenerSample")
                11 -> runSample("ModuleInfoSample")
                12 -> runSample("GdxGeneratedSample")
                0 -> {running = false
                println("exiting")
                }
                else -> {
                       println("choice is invalid")
                    }
                }
            }
        }

    private fun runSample(sampleBaseSimpleName: String) {
        println("launching sample: $sampleBaseSimpleName")
        Lwjgl3Application(SampleFactory.newSample(sampleBaseSimpleName), config)
    }
}

// package function:
fun main() {
    var game = GdxSampleLauncher()
}