package com.example.pruebakotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

//crear clase  , extender Android View Model , entregar application
class ProductoViewModel(application: Application) : AndroidViewModel(application) {

    //crear
    private val repository: ProductoRepository

    val allProduct: LiveData<List<Product>>

    init {
        //llamando base de datos
        val productosDao = ProductosDataBase.getDataBase(application).getProductDao()
        //iniciando repositorio
        repository = ProductoRepository(productosDao)
        allProduct = repository.listAllProduct

    }

    fun insertProducto(product: Product) = viewModelScope.launch {
        repository.insertProducto(product)
    }

    fun deleteProducto(product: Product) = viewModelScope.launch {
        repository.deleteProducto(product)
    }

    //
    private var selectedProduct: MutableLiveData<Product> = MutableLiveData()
    fun selected(product: Product) {
        selectedProduct.value = product
    }

    fun selectedItem(): LiveData<Product> = selectedProduct
}