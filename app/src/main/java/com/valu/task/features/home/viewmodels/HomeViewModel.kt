package com.valu.task.features.home.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valu.domain.common.FinalResponse
import com.valu.domain.home.models.Product
import com.valu.domain.home.usecases.GetAllProductsUseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val getAllProductsUseCase: GetAllProductsUseCase):ViewModel() {

    private  val TAG = "HomeViewModel"
    private val productsResponse= MutableLiveData<FinalResponse<MutableList<Product>>?>()
    val productsResponseLive: MutableLiveData<FinalResponse<MutableList<Product>>?>
        get() = productsResponse

    fun getProducts() {
        viewModelScope.launch {
            productsResponse.postValue(getAllProductsUseCase())
        }
    }
}