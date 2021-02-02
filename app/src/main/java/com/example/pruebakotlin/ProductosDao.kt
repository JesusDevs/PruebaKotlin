package com.example.pruebakotlin

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductosDao {

    //insertar , el termino suspend permite indicarle al sistema que el metodo se ejecutara
    //en corutina
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducto(product: Product)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllProductos (taskList: List<Product>)


    //live realiza la asincronia del objeto o accion
    @Query("SELECT * FROM productos_table")
     fun getAllConsumption(): LiveData<List<Product>>

    @Query("SELECT * FROM productos_table WHERE id = :mId")
    fun getProductoById(mId:Int):LiveData<Product>


    @Delete
    suspend fun deleteProduct(product: Product)

}