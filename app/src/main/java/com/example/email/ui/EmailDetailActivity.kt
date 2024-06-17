package com.example.email.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.email.databinding.ActivityEmailDetailBinding
import com.example.email.models.Email

class EmailDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmailDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = intent.getParcelableExtra<Email>("email")
        if (email != null) {
            displayEmailDetails(email)
        }
    }

    private fun displayEmailDetails(email: Email) {
        binding.emailSender.text = email.sender
        binding.emailSubject.text = email.subject
        binding.emailBody.text = email.body
        binding.emailTimestamp.text = email.timestamp.toString()
    }
}
