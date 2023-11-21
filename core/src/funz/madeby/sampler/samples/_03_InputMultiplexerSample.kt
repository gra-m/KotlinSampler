package funz.madeby.sampler.samples

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.InputMultiplexer
import funz.madeby.sampler.common.SampleBase
import funz.madeby.sampler.utils.logger

class _03_InputMultiplexerSample : SampleBase() {
    companion object {
        @JvmStatic
        private val LOG = logger<_03_InputMultiplexerSample>()
    }



    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG
// true == stops chaining.
        val inputProcessorOne = object : InputAdapter() {
            override fun keyDown(keycode: Int): Boolean {
                LOG.debug("KeyDownP1() keycode= $keycode")
                // false propagates to next input processor in the multiplexer loop
                return false
            }
            override fun keyUp(keycode: Int): Boolean {
                LOG.debug("KeyUpP1() keycode= $keycode")
                return false
            }
        }

        val inputProcessorTwo = object :InputAdapter() {
            override fun keyDown(keycode: Int): Boolean {
                LOG.debug("KeyDownP2() keycode= $keycode")
                return true
            }
            override fun keyUp(keycode: Int): Boolean {
                LOG.debug("KeyUpP2() keycode= $keycode")
                return false
            }
        }

        /*val multiplexer = InputMultiplexer()
        multiplexer.addProcessor(inputProcessorOne)
        multiplexer.addProcessor(inputProcessorTwo)
        Gdx.input.inputProcessor = multiplexer */
        Gdx.input.inputProcessor = InputMultiplexer(inputProcessorOne, inputProcessorTwo)

    }


}