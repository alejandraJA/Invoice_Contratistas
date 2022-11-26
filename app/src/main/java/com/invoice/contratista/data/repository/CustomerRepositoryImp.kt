package com.invoice.contratista.data.repository

import com.invoice.contratista.data.source.api.models.DataResponse
import com.invoice.contratista.data.source.api.models.customer.CustomerResponse
import com.invoice.contratista.data.source.api.retrofit.Service
import com.invoice.contratista.domain.repository.CustomerRepository
import retrofit2.Response
import javax.inject.Inject

class CustomerRepositoryImp @Inject constructor(
    private val service: Service
) : CustomerRepository {
    override suspend fun getCustomer(token: String): Response<DataResponse<CustomerResponse>> =
        service.getCustomer(token)
}