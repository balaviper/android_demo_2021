package com.example.assesment5.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import com.example.assesment5.SalaryApplication
import com.example.assesment5.databinding.FragmentSalaryCardBinding
import com.example.assesment5.db.BasicData
import com.example.assesment5.db.SalaryData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SalaryCardFragment : Fragment() {
    private val viewModel: DetailsViewModel by activityViewModels()

    private var _binding: FragmentSalaryCardBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSalaryCardBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayDetails()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

   private fun displayDetails(){
       val app = requireActivity().application as SalaryApplication

       val scp = CoroutineScope(Dispatchers.IO)

       scp.launch {
           val dataSource = app.db.basicDao().findAllId()
           withContext(Dispatchers.Main) {
               val adapter = ArrayAdapter(
                   requireContext(),
                   android.R.layout.simple_expandable_list_item_1,
                   dataSource
               )

               binding.salId.adapter = adapter

               binding.salId.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                       override fun onNothingSelected(parent: AdapterView<*>?) {

                       }

                       override fun onItemSelected(
                           parent: AdapterView<*>?,
                           view: View?,
                           position: Int,
                           id: Long
                       ) {
                           viewModel.setId(dataSource[position].toString().toLong())
                           Log.i("@id", "${viewModel.id.value}")
                           viewModel.id.observe(viewLifecycleOwner) {
                               scp.launch {
                                   val idData = app.db.basicDao().findAllId()
                                   if (it in idData) {
                                       val basic = app.db.basicDao().findBasicById(it)
                                       val salary = app.db.salaryDao().findSalaryById(it)


                                       withContext(Dispatchers.Main) {
                                           basicCard(basic)
                                           salaryCard(salary)
                                       }
                                   }
                               }
                           }

                       }
                   }
           }
       }
   }

    private fun basicCard(basic: BasicData) {

        binding.cbname.text = "Name : ${basic.nm}"
        binding.cbAge.text = "Age: ${basic.age.toString()}"
        binding.cbmob.text = "Mobile: ${basic.mob}"
        binding.cbmail.text = "Mail : ${basic.mail}"
        Log.i("@Salary Data", "${basic.id} ${basic.age} ${basic.mail} ${basic.nm}")

    }

    private fun salaryCard(salary: SalaryData) {

        Log.i("@Salary Data", "${salary.id} ${salary.sal} ${salary.hra} ${salary.ctc}")
        binding.scSal.text = "Basic : ${salary.sal.toString()}"
        binding.scHra.text = "HRA : ${salary.hra.toString()}"
        binding.scTa.text = "TA : ${salary.ta.toString()}"
        binding.scCtc.text = "CTC : ${salary.ctc.toString()}"
    }
}

