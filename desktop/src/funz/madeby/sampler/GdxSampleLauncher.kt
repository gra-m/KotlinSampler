//Created by Graham Duthie on 17/11/2023 11:12
package funz.madeby.sampler

import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.badlogic.gdx.utils.reflect.ClassReflection

class GdxSampleLauncher {
    private var running = true
    val config = Lwjgl3ApplicationConfiguration()

    init {
        config.setWindowSizeLimits(1080, 720, 1080, 720)
        var count = 0

        while(running) {
            var welcome = if(count == 0) "Which sample do you want to run?" else "Want to run another sample?"
            println(welcome)
            println("\n1.InputPolling\n2.InputListening\n3.InputMultiplexer[press some keys, play with true/false" +
                    "\n4.LGdxReflectionSample[MethodsAndFieldsOfActiveClass\n5.OrthographicCameraSample" +
                    "\n6.ApplicationListenerSample[CallOrder]\n7.ModuleInfoSample[The Interfaces used by LibGdx]" +
                    "\n8.GdxSampler\n0.exit")
            count++
            var choice:Int =  readLine()!!.toInt()

            when(choice) {
                1 -> runSample("funz.madeby.sampler._01_InputPollingSample")
                2 -> runSample("funz.madeby.sampler._02_InputListeningSample")
                3 -> runSample("funz.madeby.sampler._03_InputMultiplexerSample")
                4 -> runSample("funz.madeby.sampler._04_LGdxReflectionSample")
                5 -> runSample("funz.madeby.sampler._05_OrthographicCameraSample")
                6 -> runSample("funz.madeby.sampler.ApplicationListenerSample")
                7 -> runSample("funz.madeby.sampler.ModuleInfoSample")
                8 -> runSample("funz.madeby.sampler.GdxSampler")
                0 -> {running = false
                println("exiting")
                }
                else -> {
                       println("choice is invalid")
                    }
                }

            }
        }

    private fun runSample(sampleClassPath: String) {
        println("launching sample: ${sampleClassPath.substringAfterLast('.')}")

        val retrievedClassObject = ClassReflection.forName(sampleClassPath)
        // create new instance
        val reflectedApplicationListener = ClassReflection.newInstance(retrievedClassObject) as ApplicationListener

        Lwjgl3Application(reflectedApplicationListener, config)


    }
}

// package function:
fun main() {
    var game = GdxSampleLauncher()
}