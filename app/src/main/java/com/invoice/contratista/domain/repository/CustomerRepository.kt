package com.invoice.contratista.domain.repository

import com.invoice.contratista.data.source.api.models.response.DataResponse
import com.invoice.contratista.data.source.api.models.response.customer.CustomerResponse
import retrofit2.Response

interface CustomerRepository {
    suspend fun getCustomer(token: String): Response<DataResponse<CustomerResponse>>
}