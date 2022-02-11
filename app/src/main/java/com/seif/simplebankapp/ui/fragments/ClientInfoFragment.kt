package com.seif.simplebankapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.seif.simplebankapp.data.models.Clients
import com.seif.simplebankapp.databinding.FragmentClientInfoBinding
import com.seif.simplebankapp.ui.fragments.ClientInfoFragmentArgs.Companion.fromBundle
import com.seif.simplebankapp.viewmodels.ClientInfoViewModel

class ClientInfoFragment : Fragment() {
    lateinit var binding: FragmentClientInfoBinding
    lateinit var client: Clients
    lateinit var clientInfoViewModel:ClientInfoViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentClientInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clientInfoViewModel = ViewModelProvider(requireActivity())[ClientInfoViewModel::class.java]
        loadClientData()
        binding.btnTransferMoney.setOnClickListener {
            // show alert dialog to enter amount of money need to be transfered
           clientInfoViewModel.showTransferMoneyDialog(view, client)

        }
    }


    private fun loadClientData() {
        client = fromBundle(requireArguments()).Client
        binding.txtClientName.text = client.clientName
        binding.txtIFSCCode.text = client.IFSCNumber
        binding.txtCurrentBalance.text = client.currentBalance.toInt().toString()
        binding.txtEmaiil.text = client.email
        binding.txtAccountNumber.text = client.accountNumber
        binding.txtPhone.text = client.phoneNumber
    }
}