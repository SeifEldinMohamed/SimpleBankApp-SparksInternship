package com.seif.simplebankapp.data.repository

import androidx.lifecycle.LiveData
import androidx.room.Transaction
import com.seif.simplebankapp.data.models.Clients
import com.seif.simplebankapp.data.BankDatabaseDao
import com.seif.simplebankapp.data.models.Transactions

class RepositoryImp(private val dao: BankDatabaseDao): Repository {
    override suspend fun addClients(client: Clients) {
        dao.addClients(client)
    }

    override suspend fun updateClient(client: Clients) {
        dao.updateClient(client)
    }

    override  fun getAllClients(): LiveData<List<Clients>> {
        return dao.getAllClients()
    }

    override fun getSelectedClients(clientName: String): LiveData<List<Clients>> {
        return dao.getSelectedClients(clientName)
    }

    override suspend fun addTransaction(transaction: Transactions) {
        dao.addTransaction(transaction)
    }

    override fun getAllTransactions(): LiveData<List<Transactions>> {
        return dao.getAllTransactions()
    }
}