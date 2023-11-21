//Created by Graham Duthie on 21/11/2023 13:39

package funz.madeby.sampler.common

import com.badlogic.gdx.utils.reflect.ClassReflection

object SampleFactory {
    
    fun newSample(name: String): SampleBase {
        val sampleName = SampleInfos.findSampleByName(name)

            return ClassReflection.newInstance(sampleName?.claxs) as SampleBase
    }
}