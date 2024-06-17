package com.example.email.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.email.models.Email

@Dao
interface EmailDao {

    @Query("SELECT * FROM emails")
    fun getAllEmails(): List<Email>

    @Insert
    fun insertEmails(emails: List<Email>)

    @Update
    fun updateEmail(email: Email)
}
