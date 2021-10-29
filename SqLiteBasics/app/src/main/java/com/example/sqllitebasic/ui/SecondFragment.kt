package com.example.sqllitebasic.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqllitebasic.databinding.FragmentSecondBinding
import com.example.sqllitebasic.db.Dealer
import com.example.sqllitebasic.db.DealerDao
import com.example.sqllitebasic.db.DealerDatabase
import com.example.sqllitebasic.db.DealersViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private lateinit var db: DealerDatabase

    private lateinit var dealerDao: DealerDao

    private val viewModel: DealersViewModel by activityViewModels()

    private val binding get() = _binding!!

   private lateinit var dataSource: List<Dealer>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val scp = viewModel.scp.value

        db = viewModel.dataBuilder(requireContext())

        dealerDao = viewModel.dataDao(db)
        scp?.launch {
            dataSource = dealerDao.findAllDealers()
            /*
            Cannot invoke setValue on a background thread
            Cannot access database on the main thread since it may potentially lock the UI for a long period of time.
            dataSource = viewModel.getData()
            */
            dataSource.forEach {
                Log.i(
                    "@Data",
                    "${it.id} ${it.dlNm}, ${it.mobile}, ${it.isActive}, ${it.period}"
                )
            }
            withContext(Dispatchers.Main) {
                val adapter = DealerListAdapter(
                    requireContext(),
                    dataSource
                )
                binding.del.adapter = adapter
                val layoutManager = LinearLayoutManager(requireContext())
                binding.del.layoutManager = layoutManager
                binding.del.addItemDecoration(
                    DividerItemDecoration(
                        requireContext(),
                        layoutManager.orientation
                    )
                )

            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


