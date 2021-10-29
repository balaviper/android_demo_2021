package com.example.basicnavigationdrawer.ui.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.basicnavigationdrawer.R

data class HomeData(
    val name : String,
    val time : String,
    var blb : Boolean
)
class HomeAdopter(
    private val context: Context,
    private val data : List<HomeData>
) : RecyclerView.Adapter<HomeHolder>(){
    private val _clkPos = MutableLiveData<Int>()
    val clkPos: LiveData<Int> = _clkPos

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        val root = LayoutInflater.from(context).inflate(
            R.layout.recycle_view,
            parent,
            false
        )

        return HomeHolder(root)
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        holder.name().text = data[position].name
        holder.time().text = data[position].time
        holder.switch().setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "Switch2:ON" else "Switch2:OFF"
            Log.i("Switch","${message}")

            data[position].blb = isChecked
        }
        holder.reclView().setOnClickListener {
            _clkPos.value = position
        }

    }

    override fun getItemCount(): Int = data.size
}


class HomeHolder(
    private val view : View
): RecyclerView.ViewHolder(view){
    fun name() = itemView.findViewById<TextView>(R.id.textView2)
    fun time() = itemView.findViewById<TextView>(R.id.textView3)
    fun switch() = itemView.findViewById<Switch>(R.id.bulb)
    fun reclView() = itemView
}