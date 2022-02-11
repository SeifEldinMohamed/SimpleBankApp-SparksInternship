package com.seif.simplebankapp.viewmodels

import android.app.Application
import android.app.Dialog
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.findNavController
import com.seif.simplebankapp.R
import com.seif.simplebankapp.data.models.Clients
import com.seif.simplebankapp.ui.fragments.ClientInfoFragmentDirections

class ClientInfoViewModel(application: Application): AndroidViewModel(application) {

    fun showTransferMoneyDialog(view:View, client:Clients) {
        val dialog = Dialog(view.context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.transaction_dialog)
        val btnSend = dialog.findViewById<Button>(R.id.btn_send)
        val btnCancel = dialog.findViewById<Button>(R.id.btn_cancel)
        val moneyEditText = dialog.findViewById<EditText>(R.id.moneyEditText)
        btnSend.setOnClickListener {
            if (moneyEditText.text.isNullOrEmpty())
                moneyEditText.error = "please enter money to transfer!"
            else {
                val money: Float = moneyEditText.text.toString().toFloat()
                if (money <= client.currentBalance) {
                    // navigate to clientsSelectFragment
                    val action = ClientInfoFragmentDirections.actionClientInfoFragmentToSelectClientFragment(client, money)
                    view.findNavController().navigate(action)
                    dialog.dismiss()
                }
                else
                    moneyEditText.error = "your account doesn't have enough balance!"
            }
        }
        btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}