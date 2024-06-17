package com.example.email.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "emails")
data class Email(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val sender: String,
    val subject: String,
    val body: String,
    val timestamp: String,
    val currentTimeMillis: Long
) : Parcelable
