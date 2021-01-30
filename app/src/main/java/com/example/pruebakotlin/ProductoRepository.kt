package com.example.pruebakotlin

import androidx.lifecycle.LiveData

class ProductoRepository(private val productosDao: ProductosDao) {

    //val que contendra todos lo datos desde la base de datos

    val listAllProduct: LiveData<List<Product>> = productosDao.getAllConsumption()

    //funcion que crear un item o proucto en la base de datos
    suspend fun insertProducto(product: Product) {
        productosDao.insertProducto(product)
    }

    //fun que elimina un producto
    suspend fun deleteProducto(product: Product) {
        productosDao.deleteProduct(product)
    }

}