package com.example.retrofitbasics

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

class DataListAdapter(
    private val context : Context,
    private val dataSource: List<ReqResUser>
) : RecyclerView.Adapter<DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val vw = LayoutInflater.from(context).inflate(R.layout.rec_view, parent, false)
        return DataViewHolder(vw)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = dataSource[position]

        holder.firstName().text = data.first_name
        holder.lastName().text = data.last_name
        holder.mailId().text = data.email



    }

    override fun getItemCount(): Int = dataSource.size
}


class DataViewHolder(
    private val infVw : View
): RecyclerView.ViewHolder(infVw) {

    fun rootView() = infVw

    fun firstName() = infVw.findViewById<TextView>(R.id.fname)

    fun lastName() = infVw.findViewById<TextView>(R.id.lname)

    fun mailId() = infVw.findViewById<TextView>(R.id.mail)
}