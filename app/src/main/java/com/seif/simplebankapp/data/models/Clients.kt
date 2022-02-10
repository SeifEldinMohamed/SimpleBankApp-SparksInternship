package com.seif.simplebankapp.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Clients(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    val clientName: String,
    val email: String,
    val phoneNumber: String,
    val accountNumber: String,
    val IFSCNumber: String,
    val currentBalance: Double
):Parcelable
