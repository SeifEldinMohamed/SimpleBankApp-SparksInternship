package com.seif.simplebankapp.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.seif.simplebankapp.databinding.FragmentClientsBinding
import com.seif.simplebankapp.ui.adapters.ClientsAdapter
import com.seif.simplebankapp.viewmodels.ClientsViewModel
import jp.wasabeef.recyclerview.animators.ScaleInTopAnimator


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
        clientsViewModel.isAppFirstTimeRun(requireContext())
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.rvClients.adapter = clientsAdapter
        binding.rvClients.itemAnimator = ScaleInTopAnimator().apply {
            addDuration = 200
        }
    }

}