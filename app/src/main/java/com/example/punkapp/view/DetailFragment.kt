package com.example.punkapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.punkapp.R
import com.example.punkapp.ViewModel.DetailFragmentViewModel
import com.example.punkapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var detailFragmentViewModel: DetailFragmentViewModel
    private lateinit var fragmentDetailBinding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentDetailBinding = DataBindingUtil.inflate<FragmentDetailBinding>(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        )
        return fragmentDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailFragmentViewModel =
            ViewModelProviders.of(this).get(DetailFragmentViewModel::class.java)
        detailFragmentViewModel.onLoad(arguments?.getInt("uuid")!!)
        observer()
    }

    private fun observer() {
        detailFragmentViewModel.punkBeerData.observe(viewLifecycleOwner, Observer {
            fragmentDetailBinding.punkDetail = it
        })
    }
}