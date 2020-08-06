package com.allana.booksapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvBook: RecyclerView
    private var list: ArrayList<Book> = arrayListOf()

    private val titleParam = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBook = findViewById(R.id.rv_books)
        rvBook.setHasFixedSize(true)

        list.addAll(BooksData.listData)
        showRecyclerList()

    }

    private fun showSelectedHero(book: Book) {
        val moveToDetailBook = Intent(this@MainActivity, DetailBook::class.java)
        moveToDetailBook.apply {
            putExtra(DetailBook.EXTRA_TITLE, book.bookTitle)
            putExtra(DetailBook.EXTRA_AUTHOR, book.bookAuthor)
            putExtra(DetailBook.EXTRA_PRICE, book.bookPrice)
            putExtra(DetailBook.EXTRA_PHOTO, book.bookPhoto)
            putExtra(DetailBook.EXTRA_TOTAL_PAGE, book.bookTotalPage)
            putExtra(DetailBook.EXTRA_RELEASE, book.bookReleaseDate)
            putExtra(DetailBook.EXTRA_ISBN, book.bookIsbn)
            putExtra(DetailBook.EXTRA_LANGUANGE, book.bookLanguange)
            putExtra(DetailBook.EXTRA_PUBLISHER, book.bookPublisher)
            putExtra(DetailBook.EXTRA_DESCRIPTION, book.bookDescription)
            putExtra(DetailBook.EXTRA_RATING, book.bookRating)
            putExtra(DetailBook.EXTRA_ORDER, book.bookOrder)

        }
        startActivity(moveToDetailBook)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.profile -> {
                val moveToAbout = Intent(this@MainActivity, About::class.java)
                startActivity(moveToAbout)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showRecyclerList(){
        rvBook.layoutManager = LinearLayoutManager(this)
        val listBookAdapter = BookAdapter(list)
        rvBook.adapter  = listBookAdapter

        listBookAdapter.setOnItemClickCallback(object : BookAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Book) {
                showSelectedHero(data)
            }
        })
    }
}
