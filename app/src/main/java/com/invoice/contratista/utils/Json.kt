package com.invoice.contratista.utils

import com.google.gson.Gson
import com.invoice.contratista.data.api.models.ErrorResponse
import okhttp3.ResponseBody

object Json {
    fun ResponseBody.toObject() = Gson().fromJson(this.string(), ErrorResponse::class.java)
}