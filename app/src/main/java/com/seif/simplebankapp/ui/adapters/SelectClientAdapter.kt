package com.seif.simplebankapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.seif.simplebankapp.R
import com.seif.simplebankapp.data.models.Clients
import com.seif.simplebankapp.data.models.Transactions
import com.seif.simplebankapp.databinding.ItemRowClientBinding
import com.seif.simplebankapp.viewmodels.ClientsViewModel
import com.seif.simplebankapp.viewmodels.TransactionViewModel


class SelectClientAdapter(val context: Context): RecyclerView.Adapter<SelectClientAdapter.MyViewHolder>() {
   private var clients = emptyList<Clients>()
    private lateinit var fromClient: Clients
    private  var money: Double? = null
    lateinit var clientViewModel: ClientsViewModel
    lateinit var transactionViewModel: TransactionViewModel

    inner class MyViewHolder(private val binding: ItemRowClientBinding): RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(position: Int, clients: List<Clients>){

            binding.txtClientName.text = clients[position].clientName
             binding.txtBalance.text = clients[position].currentBalance.toInt().toString()
            val toClient = clients[position]
             binding.itemRowClient.setOnClickListener {
             val toClientUpdatedMoney = toClient.currentBalance + money!!
               val updatedToClient = Clients(
                   toClient.id,
                   toClient.clientName,
                   toClient.email,
                   toClient.phoneNumber,
                   toClient.accountNumber,
                   toClient.IFSCNumber,
                   toClientUpdatedMoney
               )
                 val fromClientUpdatedMoney = fromClient.currentBalance - money!!
                 val updatedFromClient = Clients(
                     fromClient.id,
                     fromClient.clientName,
                     fromClient.email,
                     fromClient.phoneNumber,
                     fromClient.accountNumber,
                     fromClient.IFSCNumber,
                     fromClientUpdatedMoney
                 )
                 clientViewModel.updateToClient(updatedToClient)
                 clientViewModel.updateFromClient(updatedFromClient)
                 val transaction = Transactions(
                     1,
                     updatedFromClient.clientName,
                     updatedToClient.clientName,
                     money!!
                 )
                 transactionViewModel.addTransaction(transaction)
                itemView.findNavController().navigate(R.id.action_selectClientFragment_to_clientsFragment)
             }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemRowClientBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       clientViewModel = ViewModelProvider(context as FragmentActivity)[ClientsViewModel::class.java]
        transactionViewModel = ViewModelProvider(context as FragmentActivity)[TransactionViewModel::class.java]
        holder.bind(position, clients)
    }

    override fun getItemCount(): Int {
        return clients.size
    }
    fun setData(data: List<Clients>){
        clients = data
        notifyDataSetChanged()
    }
    fun setValues(fromClient: Clients, money: Int){
        this.fromClient = fromClient
        this.money = money.toDouble()
    }
}