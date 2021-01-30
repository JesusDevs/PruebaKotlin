package com.example.pruebakotlin

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1)
abstract class ProductosDataBase : RoomDatabase() {
    //crear metodo bastracto para obtener el dao
    abstract fun getProductDao(): ProductosDao

    companion object {
        @Volatile
        private var INSTANCE: ProductosDataBase? = null

        fun getDataBase(context: Context): ProductosDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProductosDataBase::class.java, "taskDB"
                )
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}