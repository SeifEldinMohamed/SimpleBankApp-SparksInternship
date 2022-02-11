package com.seif.simplebankapp.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Transactions(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var from_clientName: String,
    var to_clientName: String,
    var moneyTransfer: Double
):Parcelable
