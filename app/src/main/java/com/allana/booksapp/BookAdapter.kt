package com.allana.booksapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class BookAdapter(private val listBook: ArrayList<Book>) : RecyclerView.Adapter<BookAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvBookTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvBookAuthor: TextView = itemView.findViewById(R.id.tv_author)
        val tvBookPrice: TextView = itemView.findViewById(R.id.tv_price)
        val imgBookPhoto: ImageView = itemView.findViewById(R.id.img_book_photo)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBook.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val book = listBook[position]

        Glide.with(holder.itemView.context)
            .load(book.bookPhoto)
            .apply(RequestOptions().override(100, 100))
            .into(holder.imgBookPhoto)

        holder.tvBookTitle.text = book.bookTitle
        holder.tvBookAuthor.text = book.bookAuthor
        holder.tvBookPrice.text = book.bookPrice
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listBook[holder.adapterPosition]) }


    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Book)
    }
}