//Created by Graham Duthie on 17/11/2023 09:58
package funz.madeby.sampler.utils

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle

fun String.toInternalFile(): FileHandle = Gdx.files.internal(this)