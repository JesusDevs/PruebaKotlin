package com.example.pruebakotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.pruebakotlin.databinding.FragmentFirstBinding
import com.example.pruebakotlin.databinding.FragmentSecondBinding
import java.util.Observer

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var binding : FragmentSecondBinding
    private val viewModel : ProductoViewModel by activityViewModels()
    private var idProduct : Int =0
    private var productSelected :Product? = null


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.selectedItem().observe(viewLifecycleOwner, {
           binding.nameProduct2.setText(it.item)
            binding.cantidad2.setText(it.quantity.toString().toInt())
            binding.priceProducto2.setText(it.itemPrice.toString().toInt())
            binding.editTextTextPersonName.setText(it.total.toString().toInt())

            idProduct = it.id
            productSelected=it
        })

        binding.btnSave.setOnClickListener{
            saveData()
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)

        }

        }


    fun saveData() {
        val product = binding.nameProduct2.text.toString()
        val  cantidad = binding.cantidad2.text.toString()
        val precio = binding.priceProducto2.text.toString().toInt()
        val total = binding.editTextTextPersonName.text.toString().toInt()


    }
    }
