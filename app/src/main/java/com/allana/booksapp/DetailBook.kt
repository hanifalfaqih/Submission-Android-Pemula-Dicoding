package com.allana.booksapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_book.view.*
import java.lang.reflect.Array.get

class DetailBook : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_AUTHOR = "extra_author"
        const val EXTRA_PRICE = "extra_price"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_TOTAL_PAGE = "extra_total"
        const val EXTRA_RELEASE = "extra_release"
        const val EXTRA_ISBN = "extra_isbn"
        const val EXTRA_LANGUANGE = "extra_languange"
        const val EXTRA_PUBLISHER = "extra_publisher"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_RATING = "extra_rating"
        const val EXTRA_ORDER = "extra_order"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_book)

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "Detail Buku"
        }

        val tvBookTitle: TextView = findViewById(R.id.tv_title)
        val tvBookAuthor: TextView = findViewById(R.id.tv_author)
        val tvBookPrice: TextView = findViewById(R.id.tv_price)
        val imgBookPhoto: ImageView = findViewById(R.id.img_book_photo)
        val tvTotalPage: TextView = findViewById(R.id.tv_total_page)
        val tvReleaseDate: TextView = findViewById(R.id.tv_release_date)
        val tvIsbn: TextView = findViewById(R.id.tv_isbn)
        val tvLanguange: TextView = findViewById(R.id.tv_languange)
        val tvPublisher: TextView = findViewById(R.id.tv_publisher)
        val tvDescription: TextView = findViewById(R.id.tv_description)
        val tvRating: TextView = findViewById(R.id.tv_rating)

        val bookTitle = intent.getStringExtra(EXTRA_TITLE)
        val bookAuthor = intent.getStringExtra(EXTRA_AUTHOR)
        val bookPrice = intent.getStringExtra(EXTRA_PRICE)
        val bookPhoto = intent.getIntExtra(EXTRA_PHOTO, 0)
        val bookTotalPage = intent.getStringExtra(EXTRA_TOTAL_PAGE)
        val bookReleaseDate = intent.getStringExtra(EXTRA_RELEASE)
        val bookIsbn = intent.getStringExtra(EXTRA_ISBN)
        val bookLanguange = intent.getStringExtra(EXTRA_LANGUANGE)
        val bookPublisher = intent.getStringExtra(EXTRA_PUBLISHER)
        val bookDescription = intent.getStringExtra(EXTRA_DESCRIPTION)
        val bookRating = intent.getStringExtra(EXTRA_RATING)

        tvBookTitle.text = bookTitle
        tvBookAuthor.text = bookAuthor
        tvBookPrice.text = bookPrice
        Glide.with(this)
            .load(bookPhoto)
            .into(imgBookPhoto)
        tvTotalPage.text = bookTotalPage
        tvReleaseDate.text = bookReleaseDate
        tvIsbn.text = bookIsbn
        tvLanguange.text = bookLanguange
        tvPublisher.text = bookPublisher
        tvDescription.text = bookDescription
        tvRating.text = bookRating

        val btnOrder: Button = findViewById(R.id.btn_buy)
        btnOrder.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_buy -> {
//                for (position in BooksData.bookOrder.indices){
//                    val book = Book()
//                    book.bookOrder[position].toString()
                val bookOrder = intent.getStringExtra(EXTRA_ORDER)
                val btnOrderIntent = Intent(Intent.ACTION_VIEW)
                btnOrderIntent.setData(Uri.parse(bookOrder))
                startActivity(btnOrderIntent)
            }

        }
    }
}
