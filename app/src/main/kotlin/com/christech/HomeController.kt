package com.christech
import com.christech.model.Book
import com.christech.service.BookService
import io.micronaut.http.annotation.*


@Controller("/books")
class BookController(private val bookService: BookService) {

    @Get("/{id}")
    fun getBookById(@PathVariable id: Long): com.christech.model.Book? {
        return bookService.getBookById(id)
    }

    @Post
    fun createBook(@Body book: Book): com.christech.model.Book {
        return bookService.createBook(book)
    }
}