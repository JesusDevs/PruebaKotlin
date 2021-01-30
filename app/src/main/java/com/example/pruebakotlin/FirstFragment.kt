package com.example.pruebakotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
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
        val adapter= ProductoAdapter()
        binding.rvProduct.adapter = adapter
        binding.rvProduct.layoutManager= LinearLayoutManager(context)


        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        adapter.selectItem().observe(viewLifecycleOwner){
            it?.let{
                viewModel.selectedItem()
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }}
        }
        }


