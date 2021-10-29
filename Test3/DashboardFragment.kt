package com.example.assesment3

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.assesment3.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: SalaryViewModel by activityViewModels()

        val binding = DataBindingUtil.inflate<FragmentDashboardBinding>(
            inflater,
            R.layout.fragment_dashboard,
            container,
            false
        )
        binding.lifecycleOwner = this
        binding.vm = viewModel

        binding.idSalary.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                replace<SalaryDetailsFragment>(R.id.fragmentContainerView)
                this.addToBackStack("Menu")
            }
        }
        binding.idBasic.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                replace<BasicDetailsFragment>(R.id.fragmentContainerView)
                this.addToBackStack("Menu")
            }
        }
        binding.idCard.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                replace<SalaryCardFragment>(R.id.fragmentContainerView)
                this.addToBackStack("Menu")
            }
        }

        return binding.root
    }

}