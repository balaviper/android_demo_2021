package com.example.assesment4

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.assesment4.databinding.FragmentExpenseBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExpenseFragment : Fragment() {

    private val viewModel: ExpenseViewModel by activityViewModels()

    private var _binding: FragmentExpenseBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentExpenseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataSource = listOf("Food", "Electronics", "Others")
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_expandable_list_item_1,
            dataSource
        )

        binding.expIc.adapter = adapter
        var id = 1
        binding.btSv.setOnClickListener {
            if (binding.expNm.text.isNullOrBlank() || binding.expAmt.text.isNullOrBlank() || binding.expDt.text.isNullOrBlank()) {
                Toast.makeText(requireContext(), "Some Fields cannot be empty", Toast.LENGTH_SHORT)
                    .show()
            } else {
                var ic = R.drawable.ic_launcher_background
                if(binding.expIc.selectedItem.toString() == "Food") {
                     ic = R.drawable.ic_food
                }
                else if(binding.expIc.selectedItem.toString() == "Electronics"){
                     ic = R.drawable.ic_electronics
                }
                viewModel.createExpense(
                    Expense(
                        ++id,
                        binding.expNm.text.toString(),
                        binding.expAmt.text.toString().toDouble(),
                        binding.expDt.text.toString(),
                        binding.expDec.text.toString(),
                        binding.expIc.selectedItem.toString(),
                        ic
                    )
                )


                createNotificationChannel()
                val builder = NotificationCompat.Builder(
                    requireActivity(),
                    "123"
                )
                    .setSmallIcon((R.drawable.ic_notify))
                    .setContentTitle("New data Added")
                    .setContentText("Name: ${binding.expNm.text} \n Amount: ${binding.expAmt.text}")
                    .setStyle(
                        NotificationCompat.BigTextStyle()
                            .bigText("Big Text")
                    )
                    .setPriority(NotificationCompat.PRIORITY_HIGH)

                NotificationManagerCompat
                    .from(requireActivity())
                    .notify(3231, builder.build())

                findNavController().popBackStack()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

     private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "my_data"
            val descriptionText = "this is description text"
            val importance = NotificationManager.IMPORTANCE_LOW
            val channel = NotificationChannel("123", name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}