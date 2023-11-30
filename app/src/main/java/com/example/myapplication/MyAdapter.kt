package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class MyAdapter(val list: List<Book>) : RecyclerView.Adapter<MyAdapter.BookItem>() {

    class BookItem(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.bookName)
        val price: TextView = view.findViewById(R.id.bookPrice)
        val image: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItem {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item,parent,false)
        return BookItem(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: BookItem, position: Int) {
        holder.name.text = list.get(position).name
        holder.price.text = "${list.get(position).price} RUB"
        Picasso.get().load(list.get(position).image).into(holder.image)

        holder.itemView.setOnClickListener {
            Snackbar.make(holder.itemView,"N $position", Snackbar.LENGTH_LONG).show()
        }

    }
}