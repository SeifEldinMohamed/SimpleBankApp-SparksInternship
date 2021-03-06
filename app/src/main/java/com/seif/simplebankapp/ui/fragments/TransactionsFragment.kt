package com.seif.simplebankapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.seif.simplebankapp.R
import com.seif.simplebankapp.databinding.FragmentTransactionsBinding
import com.seif.simplebankapp.ui.adapters.TransactionAdapter
import com.seif.simplebankapp.viewmodels.TransactionViewModel

class TransactionsFragment : Fragment() {
    private lateinit var binding: FragmentTransactionsBinding
    lateinit var transactionViewModel: TransactionViewModel
    private val transactionAdapter: TransactionAdapter by lazy { TransactionAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTransactionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transactionViewModel =
            ViewModelProvider(requireActivity())[TransactionViewModel::class.java]

        transactionViewModel.transactions.observe(viewLifecycleOwner, Observer {
            if(it.isNotEmpty()){
                binding.noTransactionsImg.visibility = View.GONE
                binding.txtNoTransactions.visibility = View.GONE
            }
            transactionAdapter.setData(it)
        })
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.rvTransactions.adapter = transactionAdapter
        // recycler animation
    }

}