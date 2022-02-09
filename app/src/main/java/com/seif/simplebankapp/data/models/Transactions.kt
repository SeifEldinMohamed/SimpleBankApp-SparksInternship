package com.seif.simplebankapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Transactions(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    val from_clientName: String,
    val to_clientName: String,
    val moneyTransfer: Double
)
