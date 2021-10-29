package com.example.jetpack.gridLayout

import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack.R

class GridFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_grid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recDsh = view.findViewById<RecyclerView>(R.id.recDsh)
        recDsh.layoutManager = GridLayoutManager(
            requireContext(),
            2
        )



        val adapter = RecDshAdapter(
            requireContext(),
            listOf(
                RecDsh("Instagram", R.drawable.ic_insta),
                RecDsh("FaceBook", R.drawable.ic_fb),
                RecDsh("Settings", R.drawable.ic_settings),
                RecDsh("Apple", R.drawable.ic_apple)
            )
        )

        adapter.itemClick.observe(viewLifecycleOwner) {
            when (it.menu) {
                "Instagram" -> {
                    activity?.supportFragmentManager?.commit {
                        replace<GridLoadSettings>(R.id.gridFragmentContainer)
                        this.addToBackStack("Menu")
                    }
                }
                "FaceBook" -> {
                    activity?.supportFragmentManager?.commit {
                        replace<GridLoadSettings>(R.id.gridFragmentContainer)
                        this.addToBackStack("Menu")
                    }
                }
                "Apple" -> {
                    activity?.supportFragmentManager?.commit {
                        replace<GridLoadSettings>(R.id.gridFragmentContainer)
                        this.addToBackStack("Menu")
                    }
                }
                else -> {
                    activity?.supportFragmentManager?.commit {
                        replace<GridLoadSettings>(R.id.gridFragmentContainer)
                        this.addToBackStack("Menu")
                    }
                }
            }
        }
        recDsh.adapter = adapter
    }

}