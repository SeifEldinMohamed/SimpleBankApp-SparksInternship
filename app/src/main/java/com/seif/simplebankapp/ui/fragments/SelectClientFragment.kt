package com.seif.simplebankapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.seif.simplebankapp.data.models.Clients
import com.seif.simplebankapp.databinding.FragmentSelectClientBinding
import com.seif.simplebankapp.ui.adapters.SelectClientAdapter
import com.seif.simplebankapp.ui.fragments.SelectClientFragmentArgs.Companion.fromBundle
import com.seif.simplebankapp.viewmodels.ClientsViewModel


class SelectClientFragment : Fragment() {
lateinit var binding: FragmentSelectClientBinding
 private val selectClientAdapter by lazy { SelectClientAdapter(requireContext()) }
    lateinit var clientViewModel: ClientsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSelectClientBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clientViewModel = ViewModelProvider(requireActivity())[ClientsViewModel::class.java]
        val fromClient:Clients = fromBundle(requireArguments()).fromClient
        val money: Int = fromBundle(requireArguments()).money.toInt()
        selectClientAdapter.setValues(fromClient, money)
        clientViewModel.clients.observe(viewLifecycleOwner, Observer {
            selectClientAdapter.setData(it)
        })
        setUpRecyclerView()

    }
   private fun setUpRecyclerView(){
        binding.rvSelectedClient.adapter = selectClientAdapter
       // recycler animation
    }

}