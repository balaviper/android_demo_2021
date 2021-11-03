package com.example.workermanager.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.workermanager.R
import com.example.workermanager.databinding.FragmentFirstBinding
import com.example.workermanager.worker.NetworkCheck
import com.example.workermanager.worker.SampleProgressWork

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

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

        binding.buttonFirst.setOnClickListener {
            scheduleOnce(requireContext())

        }
        checkNetwork(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun scheduleOnce(context: Context) {
        val uploadRequest = OneTimeWorkRequestBuilder<SampleProgressWork>().build()
        val wm = WorkManager.getInstance(context)
        wm.enqueue(uploadRequest)

        wm.getWorkInfoByIdLiveData(uploadRequest.id)
            .observe(viewLifecycleOwner) {
                val prg = it.progress.getInt(SampleProgressWork.KEY_FILE_PROGRESS, -1)
                binding.progressBar.progress = prg
            }
    }

    private fun checkNetwork(context: Context){
        val networkRequest = OneTimeWorkRequestBuilder<NetworkCheck>().build()
        val wm = WorkManager.getInstance(context)
        wm.enqueue(networkRequest)

        wm.getWorkInfoByIdLiveData(networkRequest.id)
            .observe(viewLifecycleOwner) {
                val ck = it.progress.getBoolean(NetworkCheck.KEY_Network, false)
                binding.ntCkeck.text = ck.toString()
            }

    }


}