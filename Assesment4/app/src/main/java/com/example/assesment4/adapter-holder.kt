package com.example.assesment4

import android.app.ActivityManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView

data class Expense(
    var id : Int,
    var expense : String,
    var amount : Double,
    var date : String,
    var desc : String,
    val itm : String,
    var ic : Int
)

class ExpenseListAdapter(
    private val context : Context,
    private val dataSource: List<Expense>
) : RecyclerView.Adapter<ExpenseViewHolder>() {
    private val _clkPos = MutableLiveData<Int>()
    val clkPos: LiveData<Int> = _clkPos

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val vw = LayoutInflater.from(context).inflate(R.layout.expense_list_item, parent, false)
        return ExpenseViewHolder(vw)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = dataSource[position]

        holder.expenseName().text = expense.expense
        holder.expenseAmt().text = "${expense.amount}"
        holder.expenseIc().setImageResource(expense.ic)

        holder.rootView().setOnClickListener {
            _clkPos.value = position

        }

    }

    override fun getItemCount(): Int = dataSource.size
}


class ExpenseViewHolder(
    private val infVw : View
): RecyclerView.ViewHolder(infVw) {

    fun rootView() = infVw

    fun expenseName() = infVw.findViewById<TextView>(R.id.txtExpNm)

    fun expenseAmt() = infVw.findViewById<TextView>(R.id.txtExpAmt)

    fun expenseIc() = infVw.findViewById<ImageView>(R.id.imgIc)
}