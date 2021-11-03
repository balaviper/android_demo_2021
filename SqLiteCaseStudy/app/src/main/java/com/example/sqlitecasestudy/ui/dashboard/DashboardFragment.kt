package com.example.sqlitecasestudy.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlitecasestudy.CaseStudyApplication
import com.example.sqlitecasestudy.R

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val vm : DashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rec = view.findViewById<RecyclerView>(R.id.recDash)

        rec.layoutManager = GridLayoutManager(
            requireContext(),
            2
        )

        val adapter = DashAdapter(
            requireContext(),
            listOf(
                DashItem(1, R.drawable.ic_launcher_background, "Expense"),
                DashItem(2, R.drawable.ic_launcher_background, "Analysis")
            ),
            vm
        )

        vm.itemClick.observe(viewLifecycleOwner) {
            when(it.id) {

            }
        }

        rec.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun accessAppInFragment() {
        val app = requireActivity().application as CaseStudyApplication
        app.db.expenseDao()
    }
}