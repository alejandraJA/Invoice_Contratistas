package com.invoice.contratista.data.source.api.models.request

data class UpdateTokenRequest(
    val username: String,
    val token: String,
)