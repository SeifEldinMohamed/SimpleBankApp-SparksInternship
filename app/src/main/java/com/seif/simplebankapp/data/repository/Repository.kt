package com.seif.simplebankapp.data.repository

import androidx.lifecycle.LiveData
import com.seif.simplebankapp.data.models.Clients
import com.seif.simplebankapp.data.models.Transactions

interface Repository {
    suspend fun addClients(client: Clients)
    suspend fun updateClient(client: Clients)
    fun getAllClients(): LiveData<List<Clients>>
    fun getSelectedClients(clientName: String): LiveData<List<Clients>>

    // transactions
    suspend fun addTransaction(transaction: Transactions)
    fun getAllTransactions(): LiveData<List<Transactions>>


}