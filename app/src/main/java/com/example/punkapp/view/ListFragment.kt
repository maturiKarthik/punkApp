package com.example.punkapp.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.punkapp.R
import com.example.punkapp.ViewModel.ListFragmentViewModel
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {

    private lateinit var listFragmentViewModel: ListFragmentViewModel
    private var recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter(arrayListOf())

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
        listFragmentViewModel.loadContent()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recyclerViewAdapter
        }

        refreshApp.setOnRefreshListener {
            listFragmentViewModel.refresh()
            refreshApp.isRefreshing = false // Stopping the refresh
        }
        setHasOptionsMenu(true)
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
            if (it) error_msg.visibility = View.VISIBLE else error_msg.visibility = View.GONE
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.setting -> {
                // Toast.makeText(context, "Setting clicked", Toast.LENGTH_SHORT).show()
                val settingaction = ListFragmentDirections.actionListFragmentToSetting2()
                Navigation.findNavController(this.requireView()).navigate(settingaction)
            }
        }
        return true
    }
}