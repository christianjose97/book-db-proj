package com.christech.service

import com.christech.model.Book
import com.christech.repository.BookRepository
import io.micronaut.context.annotation.Requires
import io.micronaut.transaction.annotation.Transactional
import jakarta.inject.Singleton
import java.util.concurrent.ConcurrentHashMap

@Singleton
@Requires(classes = [BookService::class])
class BookService(private val bookRepository: BookRepository,
                  private val customBookRepository: BookRepository) {

    private val books = ConcurrentHashMap<Long, Book>()


    fun getBookById(id: Long): Book? {
        return books[id]
    }


    fun createBook(book: Book): Book {
        val id = System.nanoTime()
        book.id = id
        books[id] = book
        return book
    }

    fun getBooksByAuthor(author: String): List<Book> {
        return bookRepository.findByAuthor(author)
    }

    fun getBookByTitle(title: String): Book? {
        return bookRepository.findByTitle(title)
    }

    fun saveBook(book: Book): Book {
        // Use custom repository method
        return customBookRepository.saveBook(book)
    }
}