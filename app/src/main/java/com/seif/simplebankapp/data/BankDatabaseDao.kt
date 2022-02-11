package com.seif.simplebankapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.seif.simplebankapp.data.models.Clients
import com.seif.simplebankapp.data.models.Transactions

@Dao
interface BankDatabaseDao {
    // clients
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addClients(client: Clients)

    @Update
    suspend fun updateClient(client: Clients)

    @Query("SELECT * FROM CLIENTS")
     fun getAllClients(): LiveData<List<Clients>>

     // Transactions
     @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun addTransaction(transaction: Transactions)

     @Query("SELECT * FROM TRANSACTIONS")
     fun getAllTransactions(): LiveData<List<Transactions>>
}