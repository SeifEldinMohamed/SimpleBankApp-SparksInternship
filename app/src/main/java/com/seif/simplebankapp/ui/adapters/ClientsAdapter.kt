package com.seif.simplebankapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.seif.simplebankapp.R
import com.seif.simplebankapp.data.models.Clients
import com.seif.simplebankapp.databinding.ItemRowClientBinding
import com.seif.simplebankapp.ui.fragments.ClientsFragment
import com.seif.simplebankapp.ui.fragments.ClientsFragmentDirections

class ClientsAdapter : RecyclerView.Adapter<ClientsAdapter.MyViewHolder>() {
    var clientsData = emptyList<Clients>()

    class MyViewHolder(private val binding: ItemRowClientBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(position: Int, clients: List<Clients>){
                binding.txtClientName.text = clients[position].clientName
                val balance = clients[position].currentBalance.toInt().toString() + " EG"
                binding.txtBalance.text = balance
                binding.itemRowClient.setOnClickListener {
                    val action =  ClientsFragmentDirections.actionClientsFragmentToClientInfoFragment(clients[position])
                    itemView.findNavController().navigate(action)
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
            holder.bind(position, clientsData)
    }

    override fun getItemCount(): Int {
        return clientsData.size
    }

    fun setData(clients: List<Clients>) {
        clientsData = clients
        notifyDataSetChanged()
    }

}