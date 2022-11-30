package com.invoice.contratista.domain.repository

import com.invoice.contratista.data.source.api.models.DataResponse
import com.invoice.contratista.data.source.api.models.customer.CustomerResponse
import retrofit2.Response

interface CustomerRepository {
    suspend fun getCustomer(token: String): Response<DataResponse<CustomerResponse>>
}