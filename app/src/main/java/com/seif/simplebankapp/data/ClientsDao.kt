package com.seif.simplebankapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.seif.simplebankapp.data.models.Clients

@Dao
interface ClientsDao {
    @Insert
    suspend fun addClients(client: Clients)

    @Query("SELECT * FROM CLIENTS")
     fun getAllClients(): LiveData<List<Clients>>
}