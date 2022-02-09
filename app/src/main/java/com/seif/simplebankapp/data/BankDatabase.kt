package com.seif.simplebankapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.seif.simplebankapp.data.models.Clients
import com.seif.simplebankapp.data.models.Transactions

private const val DATABASE_NAME = "bank_database"

@Database(entities = [Clients::class, Transactions::class], version = 1, exportSchema = false)
abstract class BankDatabase : RoomDatabase() {
    abstract fun clientsDao(): ClientsDao

    companion object {
        @Volatile
        private var instance: BankDatabase? = null

        fun getInstance(context: Context): BankDatabase {
            return if (instance != null) {
                instance!!
            } else {
                synchronized(this) { // to prevent any thread to deal with it until this thread unlock it
                    Room.databaseBuilder(
                        context,
                        BankDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                }

            }
        }
    }

}