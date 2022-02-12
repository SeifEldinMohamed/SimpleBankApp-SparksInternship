package com.seif.simplebankapp.viewmodels

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
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
    private lateinit var shared :SharedPreferences

    fun getAllSelectedClients(clientName:String):LiveData<List<Clients>>{
        return repository.getSelectedClients(clientName)
    }

    fun addClients(client:List<Clients>){
        viewModelScope.launch(Dispatchers.IO) {
            client.forEach {
                repository.addClients(it)
            }
        }
    }
    fun updateFromClient(fromClient: Clients) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateClient(fromClient)
        }
    }
    fun updateToClient(toClient: Clients) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateClient(toClient)
        }
    }
    fun isAppFirstTimeRun(context: Context){
        shared = context.getSharedPreferences("isFirstTime", Context.MODE_PRIVATE)
        if(shared.getBoolean("check",true)){
            val clients = setUpDummyClients()
            addClients(clients)
            val editor = shared.edit()
            editor.putBoolean("check",false)
            editor.apply()
        }
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