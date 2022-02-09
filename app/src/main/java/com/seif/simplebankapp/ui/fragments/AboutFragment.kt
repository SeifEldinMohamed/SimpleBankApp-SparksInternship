package com.seif.simplebankapp.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seif.simplebankapp.R
import com.seif.simplebankapp.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    lateinit var binding: FragmentAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.facebookImg.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/profile.php?id=100007229115620"))
            startActivity(intent)
        }
        binding.linkedImg.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://www.linkedin.com/in/seif-mohamed-a6b1941b2/"))
            startActivity(intent)
        }
        binding.googlePlayImg.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/dev?id=8697500693164992079"))
            startActivity(intent)
        }

    }


}