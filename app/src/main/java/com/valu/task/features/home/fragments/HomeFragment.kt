package com.valu.task.features.home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.valu.domain.home.models.Product
import com.valu.task.R
import com.valu.task.databinding.FragmentHomeBinding
import com.valu.task.databinding.ItemProductBinding
import com.valu.task.features.home.adapters.ProductsAdapter
import com.valu.task.features.home.adapters.holders.ProductItemHolder
import com.valu.task.features.home.viewmodels.HomeViewModel
import com.valu.task.util.eventListners.RecycleViewEventListener
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val TAG = "HomeFragment"
    private var _binding: FragmentHomeBinding?=null
    private val binding: FragmentHomeBinding get()=_binding!!
    private lateinit var productsAdapter: ProductsAdapter
    private val homeViewModel by sharedViewModel<HomeViewModel>()
    private lateinit var onClick: RecycleViewEventListener
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        init()
        observers()
        events()
        return binding.root
    }

    fun init() {
        homeViewModel.getProducts()
    }

    fun observers() {
        homeViewModel.productsResponseLive.observe(viewLifecycleOwner, Observer {
            if (it?.status == true) {
                showData(it?.data as MutableList<Product>)
            }

        })
    }

    fun events() {
        onClick = object : RecycleViewEventListener {
            override fun onClick(item: Product) {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item)
                findNavController().navigate(action)
            }

        }
    }

    fun showData(items: MutableList<Product>) {

        binding.apply {

            productsAdapter= ProductsAdapter(onClick)
            productsAdapter.setItemsList(items)
            rvResult.adapter=productsAdapter
            rvResult.layoutManager=GridLayoutManager(requireContext(),2)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}