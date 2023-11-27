//Created by Graham Duthie on 27/11/2023 09:25
package funz.madeby.sampler.utils

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.graphics.g2d.GlyphLayout

// Have just kept this simple here
class MainScreenRenderCentral(layout: GlyphLayout, myWorldWidth: Float = 1080f , myWorldHeight: Float = 720f) : Component{
    var x = 0f
    var y = 0f

    init {
        x = (myWorldWidth - layout.width) / 2
        y = (myWorldHeight - layout.height) / 2
    }


}