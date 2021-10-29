package com.example.navigationactivity.nagvigationLvlOne

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.navigationactivity.R


class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().title = "Main"
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val act = (requireActivity() as OldNavActivity)
        view.findViewById<Button>(R.id.btnVt).setOnClickListener {
            act.loadFragment(ViewTxnFragment.newInstance())
        }
        view.findViewById<Button>(R.id.btnSendMoney).setOnClickListener {
            act.loadFragment(ChooseRecipientFragment.newInstance())
        }
        view.findViewById<Button>(R.id.btnViewBalance).setOnClickListener {
            act.loadFragment(ViewBalanceFragment.newInstance("", ""))
        }
    }
}