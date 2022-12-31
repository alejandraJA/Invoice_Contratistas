package com.invoice.contratista.sys.domain.repository

import com.invoice.contratista.data.source.api.models.response.customer.CustomerResponse
import com.invoice.contratista.utils.ResponseApi
import retrofit2.Response

interface CustomerRepository {
    suspend fun getCustomer(token: String): Response<ResponseApi<List<CustomerResponse>>>
}