package com.seif.simplebankapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.seif.simplebankapp.data.models.Clients
import com.seif.simplebankapp.databinding.FragmentClientsBinding
import com.seif.simplebankapp.viewmodels.ClientsViewModel


class ClientsFragment : Fragment() {
    lateinit var binding: FragmentClientsBinding
    lateinit var clientsViewModel: ClientsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentClientsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clientsViewModel = ViewModelProvider(requireActivity())[ClientsViewModel::class.java]

        clientsViewModel.clients.observe(viewLifecycleOwner, Observer {

        })
        val clients = listOf<Clients>(
            Clients(
                1,
                "Seif Mohamed",
                "seifeldinmohamed101@gmail.com",
                "01000883795",
                "2501",
                "BCE2501",
                100000.0
            ),
            Clients(
                1,
                "Hazem Khaled",
                "hazem@gmail.com",
                "0123456789",
                "2502",
                "BCE2502",
                20000.0
            ),
            Clients(
                1,
                "Kareem Galal",
                "kareem.com",
                "0123456789",
                "2503",
                "BCE2503",
                1000.0
            )
        )
        clientsViewModel.addClients(clients)

    }

}