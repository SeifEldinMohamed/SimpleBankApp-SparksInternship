package com.seif.simplebankapp.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.seif.simplebankapp.data.models.Transactions
import com.seif.simplebankapp.databinding.ItemRowTransactionBinding
import com.seif.simplebankapp.utils.TransactionDiffUtil

class TransactionAdapter: RecyclerView.Adapter<TransactionAdapter.MyViewHolder>() {
    private var transactions = emptyList<Transactions>()

    class MyViewHolder(private val binding: ItemRowTransactionBinding ): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(position: Int, transactions: List<Transactions>){
            val number = position+1
            binding.txtNumber.text = "#${number.toString()}"
            binding.txtFromClient.text = "From:\n${transactions[position].from_clientName}"
            binding.txtToClient.text = "To:\n${transactions[position].to_clientName}"
            binding.txtAmount.text = "Amount: ${transactions[position].moneyTransfer.toInt().toString()}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemRowTransactionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position, transactions)
    }

    override fun getItemCount(): Int {
        return transactions.size
    }
    fun setData(transactions:List<Transactions>){
        val diffUtilCallback = TransactionDiffUtil(this.transactions, transactions)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
        this.transactions = transactions
        diffResult.dispatchUpdatesTo(this)
    }
}