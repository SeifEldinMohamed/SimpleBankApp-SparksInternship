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
    val from_clientName: String,
    val to_clientName: String,
    val moneyTransfer: Double
):Parcelable
