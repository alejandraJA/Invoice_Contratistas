package com.invoice.contratista.utils

data class ResponseApi<T>(
    val status: Boolean,
    val message: String,
    val data: T?,
)
