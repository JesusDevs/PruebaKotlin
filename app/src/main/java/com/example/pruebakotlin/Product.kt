package com.example.pruebakotlin

import androidx.room.Entity
import androidx.room.PrimaryKey

//agregar entidad y nombre tableopcional

@Entity(tableName = "productos_table")
data class Product(

        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,
        val item: String,
        val itemPrice: Int ,
        val quantity: Int,
        val total: Int )


