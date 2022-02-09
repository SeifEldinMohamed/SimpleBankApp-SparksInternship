package com.seif.simplebankapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Clients(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    val clientName: String,
    val email: String,
    val phoneNumber: String,
    val accountNumber: String,
    val IFSCNumber: String,
    val currentBalance: Double
)
