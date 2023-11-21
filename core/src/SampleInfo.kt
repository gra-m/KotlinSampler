import funz.madeby.sampler.common.SampleBase

//Created by Graham Duthie on 21/11/2023 13:48
class SampleInfo(val claxs: Class<out SampleBase>) {
    val name: String = claxs.simpleName
}