package com.example.email.ui

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.email.R
import com.example.email.databinding.ActivityComposeEmailBinding
import java.util.*

class ComposeEmailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComposeEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComposeEmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendButton.setOnClickListener {
            sendEmail()
        }

        binding.attachButton.setOnClickListener {
            // Lógica para anexar documentos
            attachDocument()
        }

        binding.reminderButton.setOnClickListener {
            // Lógica para definir o tempo de cobrança
            showTimePickerDialog()
        }

        setupSpinner()
    }

    private fun sendEmail() {
        val recipient = binding.recipientEditText.text.toString()
        val subject = binding.subjectEditText.text.toString()
        val body = binding.bodyEditText.text.toString()
        val selectedReminder = binding.reminderSpinner.selectedItem.toString()
        val reminderTime = binding.reminderTimeText.text.toString()

        // Lógica para enviar o e-mail
    }

    private fun attachDocument() {
        // Implementar a lógica para anexar um documento
    }

    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
            val time = String.format("%02d:%02d", selectedHour, selectedMinute)
            binding.reminderTimeText.text = time
        }, hour, minute, true)
        timePickerDialog.show()
    }

    private fun setupSpinner() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.reminder_options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.reminderSpinner.adapter = adapter
    }
}
