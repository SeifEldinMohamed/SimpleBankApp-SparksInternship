package com.seif.simplebankapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.seif.simplebankapp.data.BankDatabase
import com.seif.simplebankapp.data.models.Transactions
import com.seif.simplebankapp.data.repository.RepositoryImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TransactionViewModel(application: Application): AndroidViewModel(application) {
    private val dao = BankDatabase.getInstance(application).clientsDao()
    private val repository = RepositoryImp(dao)
    val transactions: LiveData<List<Transactions>> = repository.getAllTransactions()

    fun addTransaction(transaction:Transactions){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTransaction(transaction)
        }
    }
}