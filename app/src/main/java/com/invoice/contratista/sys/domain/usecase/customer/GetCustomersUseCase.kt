package com.invoice.contratista.sys.domain.usecase.customer

import com.invoice.contratista.data.source.api.models.response.customer.CustomerResponse
import com.invoice.contratista.sys.domain.repository.CustomerRepository
import com.invoice.contratista.utils.Resource
import javax.inject.Inject

class GetCustomersUseCase @Inject constructor(
    private val remoteRepository: CustomerRepository
) {
    suspend operator fun invoke(token: String): Resource<List<CustomerResponse>> {
        val customerResponse = remoteRepository.getCustomer(token)
        return if (customerResponse.code() != 200) {
            Resource.error("different code")
        } else {
            val customer = customerResponse.body()!!
            if (!customer.status) Resource.success(emptyList())
            else Resource.success(customer.data)
        }
    }
}