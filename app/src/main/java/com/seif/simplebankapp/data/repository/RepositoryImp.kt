package com.seif.simplebankapp.data.repository

import androidx.lifecycle.LiveData
import com.seif.simplebankapp.data.models.Clients
import com.seif.simplebankapp.data.ClientsDao

class RepositoryImp(private val dao: ClientsDao): Repository {
    override suspend fun addClients(client: Clients) {
        dao.addClients(client)
    }

    override  fun getAllClients(): LiveData<List<Clients>> {
        return dao.getAllClients()
    }
}