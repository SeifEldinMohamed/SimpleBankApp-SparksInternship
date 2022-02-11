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
import com.seif.simplebankapp.ui.adapters.ClientsAdapter
import com.seif.simplebankapp.viewmodels.ClientsViewModel


class ClientsFragment : Fragment() {
    lateinit var binding: FragmentClientsBinding
    private lateinit var clientsViewModel: ClientsViewModel
    private val clientsAdapter by lazy { ClientsAdapter() }
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
            clientsAdapter.setData(it)
        })
        val clients = setUpDummyClients()
        clientsViewModel.addClients(clients)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.rvClients.adapter = clientsAdapter
    }

    private fun setUpDummyClients(): List<Clients> {
        return listOf<Clients>(
            Clients(
                1,
                "Seif Mohamed",
                "seifeldinmohamed101@gmail.com",
                "01000883795",
                "20192501",
                "BCE2501",
                100000.0
            ),
            Clients(
                2,
                "Hazem Khaled",
                "hazem@gmail.com",
                "0123456789",
                "20192502",
                "BCE2502",
                20000.0
            ),
            Clients(
                3,
                "Kareem Galal",
                "kareem@gmail.com",
                "0123456789",
                "20192503",
                "BCE2503",
                1000.0
            ),
            Clients(
                4,
                "Ahmed Tarek",
                "ahmed@gmail.com",
                "0123456789",
                "20192504",
                "BCE2504",
                50000.0
            ),
            Clients(
                5,
                "Ashraf Abbas",
                "ashraf@gmail.com",
                "0123456789",
                "20192505",
                "BCE2505",
                30000.0
            ),
            Clients(
                6,
                "Mohamed Hassan",
                "mohamed@gmail.com",
                "0123456789",
                "20192506",
                "BCE2506",
                50000.0
            ),
            Clients(
                7,
                "Youssef Atef",
                "youssef@gmail.com",
                "0123456789",
                "20192507",
                "BCE2507",
                7000.0
            ),
            Clients(
                8,
                "Ibrahim Khaled",
                "ibrahim@gmail.com",
                "0123456789",
                "20192508",
                "BCE2508",
                800000.0
            ),
            Clients(
                9,
                "Mustafa Hassan",
                "mustafa@gmail.com",
                "0123456789",
                "20192508",
                "BCE2508",
                40000.0
            ),
            Clients(
                10,
                "Khaled Hassan",
                "khaled@gmail.com",
                "0123456789",
                "20192510",
                "BCE2510",
                70000.0
            )
        )
    }
}