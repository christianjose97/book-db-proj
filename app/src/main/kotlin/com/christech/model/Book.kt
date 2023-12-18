package com.christech.model

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

@Introspected
@Serdeable
data class Book(
        var id: Long? = null,
        var title: String? = null,
        var author: String? = null
)
