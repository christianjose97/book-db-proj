package com.christech.repository

import com.christech.model.Book
import io.micronaut.core.annotation.NonNull

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.data.repository.CrudRepository

@Repository
interface BookRepository : CrudRepository<Book, Long> {

    fun findByAuthor(author: String): List<Book>

    fun findByTitle(title: String): Book?

    fun saveBook(entity: Book): Book

}