//Created by Graham Duthie on 21/11/2023 10:55
package funz.madeby.sampler.common

import com.badlogic.gdx.utils.Array
import funz.madeby.sampler.samples.*

/**
 * Created to hold information for SampleBase files will hold name of sample and class to be run
 * <out SampleBase> denotes that this class is just accepting SampleBase.
 */
class SampleInfo (val claxs: Class<out SampleBase>){
            val name: String = claxs.simpleName

    val allSamples = arrayListOf(
        SampleInfo(_01_InputPollingSample::class.java),
        SampleInfo(_02_InputListeningSample::class.java),
        SampleInfo(_03_InputMultiplexerSample::class.java),
        SampleInfo(_04_LGdxReflectionSample::class.java),
        SampleInfo(_05_OrthographicCameraSample::class.java),
        SampleInfo(_06_ViewportSample::class.java),
        SampleInfo(_07_SpriteBatchSample::class.java),
        SampleInfo(ApplicationListenerSample::class.java),
        SampleInfo(ModuleInfoSample::class.java),
        SampleInfo(GdxGeneratedSample::class.java),
    )

    // kept as a reminder for K loops
    fun getSaammppleNames() : Array<String> {
        val sampleNames = Array<String>()

       /* for(sampleClass in allSamples)
            sampleNames.add(sampleClass.name)*/
        println("SampleInfo getSampleNames has KT loop examples")
        allSamples.forEachIndexed { i, it -> println("Key == it[$i] value == ${it.name}") }

        /*allSamples.forEach {it -> sampleNames.add(it.name)}*/
        allSamples.forEach {sampleNames.add(it.name)}
        sampleNames.sort()

        return sampleNames }


    fun getSampleNames() = allSamples.associateBy {it.name}.keys.toList().sorted().toTypedArray()

    fun findSampleByName(name: String) = allSamples.find {it.name == name}
    
}