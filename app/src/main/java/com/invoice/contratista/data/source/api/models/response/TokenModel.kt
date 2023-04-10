package com.invoice.contratista.data.source.api.models.response

import java.util.*

data class TokenModel(
    val token: String,
    val expiration: Date,
)