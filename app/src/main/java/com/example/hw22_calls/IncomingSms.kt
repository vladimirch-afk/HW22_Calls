package com.example.hw22_calls

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsManager
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast

class IncomingSms : BroadcastReceiver() {
    val sms: SmsManager = SmsManager.getDefault()

    override fun onReceive(context: Context?, intent: Intent?) {
        val bundle: Bundle? = intent?.extras
        try {
            if (bundle != null) {
                val pdusObj = bundle.get("pdus") as Array<*>
                for (i in pdusObj.indices) {
                    val currentMessage = SmsMessage.createFromPdu(pdusObj[i] as ByteArray)
                    val phoneNumber = currentMessage.displayOriginatingAddress
                    val senderNum = phoneNumber
                    val message = currentMessage.displayMessageBody
                    Log.i("SmsReceiver", "senderNum: $senderNum; message: $message")
                    val duration = Toast.LENGTH_LONG
                    val toast = Toast.makeText(
                        context,
                        "senderNum: $senderNum, message: $message",
                        duration
                    )
                    toast.show()
                }
            }

        } catch (e : Exception) {
            Log.e("SmsReceiver", "Exception smsReceiver" + e)
        }
    }
}