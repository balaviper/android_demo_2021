package com.example.jetpack.gridLayout

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack.R

data class RecDsh(
    val menu : String,
    val icon : Int
)

class RecDshAdapter(
    private val context : Context,
    private val dataSource : List<RecDsh>
) : RecyclerView.Adapter<RecDshViewHolder>() {

    private val _itemClick = MutableLiveData<RecDsh>()
    val itemClick : LiveData<RecDsh> = _itemClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecDshViewHolder {
        val vw = LayoutInflater.from(context).inflate(R.layout.rec_dsh_item, parent, false)
        return RecDshViewHolder(vw)
    }

    override fun onBindViewHolder(holder: RecDshViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            val click = it.tag as RecDsh

            _itemClick.value = click
        }
        holder.itemView.tag = dataSource[position]
        holder.IconChange().setImageResource(dataSource[position].icon)
        holder.TextViewchange().setText(dataSource[position].menu)
    }

    override fun getItemCount(): Int = dataSource.size
}

class RecDshViewHolder(
    private val view: View
) : RecyclerView.ViewHolder(view){

    fun TextViewchange() = view.findViewById<TextView>(R.id.lbMn)

    fun IconChange() = view.findViewById<ImageView>(R.id.icMn)

}