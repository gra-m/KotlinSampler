//Created by Graham Duthie on 28/11/2023 10:43
package funz.madeby.sampler.samples

import com.badlogic.gdx.utils.Pool.Poolable
import funz.madeby.sampler.common.SampleBase
import funz.madeby.sampler.samples.config.Config

class _10_PoolingSample: SampleBase() {
}

class Bullet: Poolable {
    var alive = true
    var timeAlive = 0f

    fun update(delta: Float) {
        timeAlive += delta
        if (timeAlive > Config.BULLET_ALIVE_MAXIMUM )
            alive = false
    }

    override fun reset() {
        alive = true
        timeAlive = 0f
    }

}