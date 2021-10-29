package com.example.jetpack.emicalLivemodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class EmiViewModel: ViewModel() {
    val emi : MutableLiveData<Double> = MutableLiveData(0.0)

    val p : MutableLiveData<Int> = MutableLiveData(0)
    val r : MutableLiveData<Int> = MutableLiveData(0)
    val n : MutableLiveData<Int> = MutableLiveData(0)

    fun changeProgress(progress : Int, type : String) {
        when (type) {
            "P" -> p.value = progress
            "R" -> r.value = progress
            else -> n.value = progress
        }
        emi.value = emiCalc(
            p.value?.toDouble() ?: 0.0  ,
            r.value?.toDouble() ?: 0.0 ,
            n.value?.toDouble() ?: 0.0
        )
    }

    fun etChangeProgress(progress: String, type : String) {
        val prg = if(progress.isNotEmpty()) progress.toInt() else 0
        when (type) {
            "P" -> p.value = prg
            "R" -> r.value = prg
            else -> n.value = prg
        }
        emi.value = emiCalc(
            p.value?.toDouble() ?: 0.0  ,
            r.value?.toDouble() ?: 0.0 ,
            n.value?.toDouble() ?: 0.0
        )
    }

    fun getProgress(type : String) = when(type) {
        "P" -> p
        "R" -> r
        else -> n
    }


    fun emiCalc(
        p: Double,
        r: Double,
        t: Double
    ): Double {
        var r = r
        var t = t
        val emi: Double
        r = r / (12 * 100)
        t = t * 12
        emi = (p * r * Math.pow((1 + r), t)
                / (Math.pow((1 + r), t) - 1))
        return emi
    }
}