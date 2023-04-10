package com.invoice.contratista.data.source.api.models.response

data class ResponseApi<T>(
    val status: Boolean,
    val message: String,
    val data: T?,
)
