//Created by Graham Duthie on 17/11/2023 20:42
package funz.madeby.sampler.samples

import com.badlogic.gdx.InputProcessor

interface MyInputProcessor: InputProcessor {

    override fun keyDown(keycode: Int): Boolean {
        /* default implementation */
        return true
    }

    override fun keyTyped(character: Char): Boolean {
        /* default implementation */
        return true
    }

    override fun keyUp(keycode: Int): Boolean {
        /* default implementation */
        return true
    }

    override fun scrolled(amountX: Float, amountY: Float): Boolean {
        /* default implementation */
        return true
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
        /* default implementation */
        return true
    }

    override fun touchCancelled(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        /* default implementation */
        return true
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
        /* default implementation */
        return true
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        /* default implementation */
        return true
    }
}