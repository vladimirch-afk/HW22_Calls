package com.example.hw22_calls

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class DeleteContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_contact)

        val name = findViewById<EditText>(R.id.nameText)
        val dButton = findViewById<Button>(R.id.delete)
        val cButton = findViewById<Button>(R.id.cancel)

        dButton.setOnClickListener {
            deleteContact(name)
        }

        cButton.setOnClickListener {
            cancel()
        }
    }

    private fun deleteContact(text: EditText) {
        val str = text.text.toString()
        MainActivity.deleteContact(str)
        finish()
    }

    private fun cancel() {
        finish()
    }
}