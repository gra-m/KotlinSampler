//Created by Graham Duthie on 15/11/2023 12:06 -1h
package funz.madeby.sampler

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

fun main() {

    println("app is null before constructor = ${Gdx.app}")
    println("input as well = ${Gdx.input}")

    Lwjgl3Application(ModuleInfoSample(), Lwjgl3ApplicationConfiguration())
    
    println("app = ${Gdx.app}")
    println("input = ${Gdx.input}")
    
}


