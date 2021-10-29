package com.example.sqllitebasic.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.sqllitebasic.R
import com.example.sqllitebasic.db.Dealer

class DealerListAdapter(
    private val context : Context,
    private val dataSource: List<Dealer>
) : RecyclerView.Adapter<DealerViewHolder>() {
    private val _clkPos = MutableLiveData<Int>()
    val clkPos: LiveData<Int> = _clkPos

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealerViewHolder {
        val vw = LayoutInflater.from(context).inflate(R.layout.dealer_recycle_view, parent, false)
        return DealerViewHolder(vw)
    }

    override fun onBindViewHolder(holder: DealerViewHolder, position: Int) {
        val data = dataSource[position]

        holder.dealerName().text = data.dlNm
        holder.dealerMobile().text = data.mobile
        holder.dealerPeriod().text = data.period.toString()

        holder.rootView().setOnClickListener {
            _clkPos.value = position
        }

    }

    override fun getItemCount(): Int = dataSource.size
}


class DealerViewHolder(
    private val infVw : View
): RecyclerView.ViewHolder(infVw) {

    fun rootView() = infVw

    fun dealerName() = infVw.findViewById<TextView>(R.id.txtNm)

    fun dealerMobile() = infVw.findViewById<TextView>(R.id.txtMob)

    fun dealerPeriod() = infVw.findViewById<TextView>(R.id.txtPd)
}