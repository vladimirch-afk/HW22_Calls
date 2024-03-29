package com.example.hw22_calls

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CustomRecyclerAdapter (
    context: Context?,
    private val images: MutableList<Image>
) :
    RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>() {
    private val inflater: LayoutInflater
    private val ctx: Context?

    init {
        inflater = LayoutInflater.from(context)
        ctx = context
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = images[position]
        holder.name.text = image.name
        holder.comment.text = image.comment
        holder.button1.setOnClickListener {
            (ctx as MainActivity).launchDialer(image.number)
        }
        holder.button2.setOnClickListener {
            (ctx as MainActivity).launchSMSSender(image.number)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val comment: TextView
        val button1: ImageView
        val button2: ImageView

        init {
            name = view.findViewById(R.id.tvName)
            comment = view.findViewById(R.id.commentView)
            button1 = view.findViewById(R.id.phone)
            button2 = view.findViewById(R.id.message)
        }
    }
}

