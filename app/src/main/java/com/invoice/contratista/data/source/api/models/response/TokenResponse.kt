package com.invoice.contratista.data.source.api.models.response

import java.util.Date

data class TokenResponse(
    val token: String,
    val expiration: Date,
)