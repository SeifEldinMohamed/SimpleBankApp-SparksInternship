package com.seif.simplebankapp.data.repository

import androidx.lifecycle.LiveData
import com.seif.simplebankapp.data.models.Clients

interface Repository {
    suspend fun addClients(client: Clients)
     fun getAllClients(): LiveData<List<Clients>>
}