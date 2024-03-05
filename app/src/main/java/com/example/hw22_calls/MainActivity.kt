package com.example.hw22_calls

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), View.OnClickListener
{
    companion object {

    }
    private val entries = 6
    private lateinit var phoneNum: MutableList<String>
    private lateinit var buttonLabels: MutableList<String>
    private val images = mutableListOf<Image>()

    fun populateArrays() {
        phoneNum.add("+7(930)839-31-89")
        phoneNum.add("+7(965)325-04-57")
//        phoneNum[2] = "345-678-90-12"
//        phoneNum[3] = "456-789-01-23"
//        phoneNum[4] = "567-890-12-34"
//        phoneNum[5] = "678-901-23-45"
        buttonLabels.add("Чечуров Владимир")
        buttonLabels.add("Друг1")
//        buttonLabels[2] = "Семеныч Сеня"
//        buttonLabels[3] = "Кузнецова Катя"
//        buttonLabels[4] = "Смирнова Саша"
//        buttonLabels[5] = "Попова Полина"
        images.add(Image("Чечуров Владимир", "+7(930)839-31-89"))
        images.add(Image("Друг1", "+7(965)325-04-57"))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        phoneNum = mutableListOf()
        buttonLabels = mutableListOf()
        populateArrays()

        val layoutManager = LinearLayoutManager(this);

        val recyclerView = findViewById<RecyclerView>(R.id.review1)
        val adapter = CustomRecyclerAdapter(this, images)
        recyclerView.layoutManager = layoutManager;
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

        val newContact = findViewById<Button>(R.id.newContact)


    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.button1 -> launchDialer(phoneNum[0])
            R.id.button2 -> launchDialer(phoneNum[1])
        }

    }


    fun launchDialer(number : String) {
        val numberToDial = "tel:" + number
        startActivity(Intent (Intent.ACTION_DIAL, Uri.parse(numberToDial)))
    }

    fun launchSMSSender(number : String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("smsto:$number")) //provide a valid number

        intent.putExtra("sms_body", "sms") //provide an sms body

        startActivity(intent)
    }
}

