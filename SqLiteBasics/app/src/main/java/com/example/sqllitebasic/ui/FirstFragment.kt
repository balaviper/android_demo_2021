package com.example.sqllitebasic.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.sqllitebasic.databinding.FragmentFirstBinding
import com.example.sqllitebasic.db.Dealer
import com.example.sqllitebasic.db.DealerDao
import com.example.sqllitebasic.db.DealerDatabase
import com.example.sqllitebasic.db.DealersViewModel



/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private lateinit var db: DealerDatabase

    private lateinit var dealerDao: DealerDao

    private val viewModel: DealersViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.coRoutine()
        viewModel.dataBaseInit(requireContext())
        db = viewModel.dataBuilder(requireContext())
        dealerDao = viewModel.dataDao(db)

        binding.btnsave.setOnClickListener {
            if (binding.dlName.text.isNullOrBlank() || binding.dlMobile.text.isNullOrBlank() || binding.dlPeriod.text.isNullOrBlank()) {
                binding.txtStatus.text = "Field cannot be empty"
                Toast.makeText(requireContext(), "Field cannot be empty", Toast.LENGTH_LONG).show()
            } else {

                val dlr = Dealer(
                    dlNm = binding.dlName.text.toString(),
                    isActive = binding.switch1.isChecked,
                    mobile = binding.dlMobile.text.toString(),
                    period = binding.dlPeriod.text.toString().toInt(),
                )
                viewModel.insertData(dlr)
                binding.dlName.setText("")
                binding.dlMobile.setText("")
                binding.dlPeriod.setText("")
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}