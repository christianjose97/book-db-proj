package com.christech.model

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Entity

@Entity
@Introspected
@Serdeable
data class Book(
        @field:Id
        @field: GeneratedValue
        var id: Long? = null,
        var title: String? = null,
        var author: String? = null
)
