package com.example.punkapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.punkapp.R
import com.example.punkapp.ViewModel.ListFragmentViewModel
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {

    private lateinit var listFragmentViewModel: ListFragmentViewModel
    private  var recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listFragmentViewModel = ViewModelProviders.of(this).get(ListFragmentViewModel::class.java)
        listFragmentViewModel.refresh()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recyclerViewAdapter
        }
        observe()
    }

    private fun observe() {
        listFragmentViewModel.loadingData.observe(viewLifecycleOwner, Observer {
            if (!it) progressBar.visibility = View.GONE
        })

        listFragmentViewModel.listOfData.observe(viewLifecycleOwner, Observer {
            recyclerViewAdapter.setData(it!!)
        })

        listFragmentViewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            if (!it) error_msg.visibility = View.GONE
        })
    }
}