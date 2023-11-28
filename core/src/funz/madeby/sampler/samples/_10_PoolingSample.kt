//Created by Graham Duthie on 28/11/2023 10:43
package funz.madeby.sampler.samples

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.Pool
import com.badlogic.gdx.utils.Pool.Poolable
import funz.madeby.sampler.common.SampleBase
import funz.madeby.sampler.samples.config.Config
import funz.madeby.sampler.utils.logger

class _10_PoolingSample: SampleBase() {
    companion object {
        @JvmStatic
        private val LOG = logger<_10_PoolingSample>()
    }

    private val bullets = GdxArray<Bullet>()
    private var timer = 0f

    private val bulletPool = object :  Pool<Bullet>(10) {
        override fun newObject(): Bullet = Bullet()

        override fun free(bullet: Bullet?) {
            LOG.debug("Before free bullet = $bullet free = $free")
            super.free(bullet)
            LOG.debug("After free bullet = $bullet free = $free")
        }

        override fun obtain(): Bullet {
            LOG.debug("Before obtain bullet free = $free")
            val bullet = super.obtain()
            LOG.debug("After obtain bullet free = $free")
            return  bullet
        }

        override fun reset(bullet: Bullet?) {
            LOG.debug("Resetting object = $bullet")
            super.reset(bullet)
        }



    }

    override fun create() {
        Gdx.app.logLevel = Application.LOG_DEBUG

    }

    override fun render() {
    }

    override fun dispose() {
        bulletPool.freeAll(bullets)
        bulletPool.clear()
        bullets.clear()

    }


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