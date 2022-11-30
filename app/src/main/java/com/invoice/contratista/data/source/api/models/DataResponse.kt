package com.invoice.contratista.data.source.api.models

import com.google.gson.annotations.SerializedName

data class DataResponse<out T>(
    @SerializedName("data")
    val data: List<T>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)