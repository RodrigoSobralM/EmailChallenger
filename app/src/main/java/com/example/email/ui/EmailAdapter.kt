package com.example.email.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.email.databinding.ItemEmailBinding
import com.example.email.models.Email

class EmailAdapter(private val emails: List<Email>, private val onEmailClicked: (Email) -> Unit) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val binding = ItemEmailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        holder.bind(emails[position])
    }

    override fun getItemCount(): Int = emails.size

    inner class EmailViewHolder(private val binding: ItemEmailBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(email: Email) {
            binding.emailSender.text = email.sender
            binding.emailSubject.text = email.subject
            binding.emailBodyPreview.text = email.body
            binding.emailTimestamp.text = email.timestamp.toString()

            binding.root.setOnClickListener {
                onEmailClicked(email)
            }
        }
    }
}
