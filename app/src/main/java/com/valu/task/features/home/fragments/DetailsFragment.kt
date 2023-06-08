package com.valu.task.features.home.fragments

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.valu.domain.home.models.Product
import com.valu.task.R
import com.valu.task.databinding.FragmentDetailsBinding
import com.valu.task.databinding.FragmentHomeBinding
import com.valu.task.features.home.viewmodels.HomeViewModel
import com.valu.task.util.helper
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailsFragment : Fragment() {

    private val TAG = "DetailsFragment"
    private  var _binding: FragmentDetailsBinding?=null
    private val binding: FragmentDetailsBinding get()=_binding!!
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        events()
        showData(args.product)

        return binding.root
    }

    fun events(){
        binding.apply {
            btnClose.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }


    fun showData(details:Product?):Boolean{

            if(helper.checkProductIsValid(details)){
                binding.apply {
                    helper.loadImage(requireContext(),details?.image!!,binding.img)
                    tvTitle.text=details?.title
                    tvPrice.text= "${details.price.toString()} ${getString(com.valu.resources.R.string.currency)}"
                    tvDescription.text=details?.description
                    rateBar.rating=details?.rating?.rate!!
                    return true
                }
            }else{
                return false
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}