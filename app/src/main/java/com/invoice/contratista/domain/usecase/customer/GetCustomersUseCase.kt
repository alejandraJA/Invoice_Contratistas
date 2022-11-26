package com.invoice.contratista.domain.usecase.customer

import com.invoice.contratista.data.source.api.models.customer.CustomerResponse
import com.invoice.contratista.domain.repository.CustomerRepository
import com.invoice.contratista.utils.Constants
import com.invoice.contratista.utils.Json.toObject
import com.invoice.contratista.utils.Resource
import javax.inject.Inject

class GetCustomersUseCase @Inject constructor(
    private val remoteRepository: CustomerRepository,
) {
    suspend operator fun invoke(): Resource<List<CustomerResponse>> {
        val customerResponse = remoteRepository.getCustomer(Constants.TOKEN)
        return if (customerResponse.code() != 200) {
            val customerError = customerResponse.errorBody()!!.toObject()
            Resource.error(customerError.message)
        } else {
            val customer = customerResponse.body()!!
            if (customer.totalResults == 0) Resource.success(emptyList())
            else Resource.success(customer.data)
        }
    }
}