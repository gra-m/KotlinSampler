//Created by Graham Duthie on 21/11/2023 10:48
package funz.madeby.sampler.common

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.InputProcessor

abstract class SampleBase: ApplicationAdapter(), InputProcessor {


    override fun keyTyped(character: Char) = false
    override fun keyUp(keycode: Int) = false
    override fun keyDown(keycode: Int) = false
    override fun mouseMoved(screenX: Int, screenY: Int) = false
    override fun scrolled(amountX: Float, amountY: Float) = false
    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int) = false
    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int) = false
    override fun touchCancelled(screenX: Int, screenY: Int, pointer: Int, button: Int) = false
    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int) = false


}