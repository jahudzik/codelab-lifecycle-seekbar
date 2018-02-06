package com.jahu.lifecycle

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class SeekBarViewModel : ViewModel() {

    val seekBarValue = MutableLiveData<Int>()

}
