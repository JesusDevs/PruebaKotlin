package com.example.pruebakotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebakotlin.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var binding : FragmentFirstBinding
    private val viewModel : ProductoViewModel by activityViewModels()


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //instaniar adapter
        val adapter = ProductoAdapter()
        binding.rvProduct.adapter = adapter
        binding.rvProduct.layoutManager = LinearLayoutManager(context)
       val product1=Product(1,"name",200,2,4000)
       val product0= Product(4,"papas",2000,3,3500)
        val product2=Product(2,"name",200,2,4000)
        val product3=Product(3,"name",200,2,4000)
        viewModel.insertProducto(product1)
        viewModel.insertProducto(product2)
        viewModel.insertProducto(product3)
        viewModel.insertProducto(product0)
        
        // observando objeto expuesto en viewmodel
        viewModel.allProduct.observe(viewLifecycleOwner, Observer {
        adapter.update(it)
       })


        adapter.selectItem().observe(viewLifecycleOwner) {
            it?.let {
                viewModel.selectedItem()
            }
        }

        binding.fab.setOnClickListener {
           findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
    fun llenarlista(){

    }
}




