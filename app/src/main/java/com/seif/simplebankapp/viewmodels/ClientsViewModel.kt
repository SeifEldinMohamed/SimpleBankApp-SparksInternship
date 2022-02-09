package com.seif.simplebankapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.seif.simplebankapp.data.BankDatabase
import com.seif.simplebankapp.data.models.Clients
import com.seif.simplebankapp.data.repository.RepositoryImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClientsViewModel(application: Application): AndroidViewModel(application) {
    private val dao = BankDatabase.getInstance(application).clientsDao()
    private val repository = RepositoryImp(dao)
    val clients: LiveData<List<Clients>> = repository.getAllClients()
    fun addClients(client:List<Clients>){
        viewModelScope.launch(Dispatchers.IO) {
            client.forEach {
                repository.addClients(it)
            }
        }
    }
}