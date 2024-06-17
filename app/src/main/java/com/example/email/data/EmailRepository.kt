package com.example.email.data

import com.example.email.models.Email

class EmailRepository(private val emailDao: EmailDao) {

    fun getEmails(): List<Email> {
        return emailDao.getAllEmails()
    }

    fun insertEmails(emails: List<Email>) {
        emailDao.insertEmails(emails)
    }

    fun updateEmail(email: Email) {
        emailDao.updateEmail(email)
    }
}
