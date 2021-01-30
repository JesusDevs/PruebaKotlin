package com.example.pruebakotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebakotlin.databinding.ProductoItemBinding


class ProductoAdapter : RecyclerView.Adapter<ProductoAdapter.ProductVH>() {
    //crear lista
    private var mListaProduct = listOf<Product>()
    private val selectedProduct = MutableLiveData<Product>()
    //metodo para obtener valor en fragmento
    fun selectItem()=MutableLiveData<Product>()

    fun update (lisTask: List<Product>){
        mListaProduct = lisTask
        notifyDataSetChanged()
    }

    inner class ProductVH (private val binding: ProductoItemBinding):
            RecyclerView.ViewHolder(binding.root), View.OnClickListener{

                fun bind (product: Product) {
                    binding.edTotal.setText(product.total.toString())
                    binding.nameProduct.setText(product.item.toString())
                    binding.priceProducto.setText(product.itemPrice.toString())
                    binding.cantidad.setText(product.quantity.toString())
                    itemView.setOnClickListener(this)
                }

        override fun onClick(p0: View?) {
            selectedProduct.value =mListaProduct[adapterPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
        return ProductVH(ProductoItemBinding.inflate
        (LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ProductoAdapter.ProductVH, position: Int) {
        val product = mListaProduct[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = mListaProduct.size
    }




