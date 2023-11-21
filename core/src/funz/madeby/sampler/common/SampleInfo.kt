//Created by Graham Duthie on 21/11/2023 10:55
package funz.madeby.sampler.common

/**
 * Created to hold information for SampleBase files will hold name of sample and class to be run
 * <out SampleBase> denotes that this class is just accepting SampleBase.
 */
class SampleInfo (val claxs: Class<out SampleBase>){
            val name: String = claxs.simpleName
    
}