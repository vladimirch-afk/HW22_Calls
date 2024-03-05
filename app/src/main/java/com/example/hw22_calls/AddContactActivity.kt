package com.example.hw22_calls

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AddContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        val saveButton = findViewById<Button>(R.id.saveButton)
        val cancelButton = findViewById<Button>(R.id.cancelButton)
        val name = findViewById<TextView>(R.id.name)
        val number = findViewById<TextView>(R.id.number)
        val comment = findViewById<TextView>(R.id.comment)

        saveButton.setOnClickListener {
            addContact(name, number, comment)
        }

        cancelButton.setOnClickListener {
            cancel()
        }
    }

    fun addContact(name: TextView, number : TextView, comment : TextView) {
        val contact = Image(name.text.toString(), number.text.toString(), comment.text.toString())
        MainActivity.addContact(contact)
        finish()
    }

    fun cancel() {
        finish()
    }
}