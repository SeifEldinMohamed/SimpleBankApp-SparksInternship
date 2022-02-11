package com.seif.simplebankapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.seif.simplebankapp.data.models.Transactions

class TransactionDiffUtil(
    private val oldList: List<Transactions>,
    private val newList: List<Transactions>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[newItemPosition] == newList[oldItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}