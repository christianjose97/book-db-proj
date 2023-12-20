package com.christech.service

import com.christech.model.Book
import com.christech.repository.BookRepository
import io.micronaut.context.annotation.Requires
import jakarta.inject.Singleton
import java.util.concurrent.ConcurrentHashMap

@Singleton
class BookService(private val bookRepository: BookRepository) {

    fun create(book: Book): Book =
        bookRepository.save(book)

}