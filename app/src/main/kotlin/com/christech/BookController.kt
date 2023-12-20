package com.christech
import com.christech.model.Book
import com.christech.service.BookService
import io.micronaut.http.annotation.*


@Controller("/books")
class BookController(private val bookService: BookService) {

    @Post
    fun create(books: Book) =
        bookService.create(book = books.toModel())

    private fun Book.toModel() :Book =
        Book(
            author = this.author,
            title = this.title
        )
}