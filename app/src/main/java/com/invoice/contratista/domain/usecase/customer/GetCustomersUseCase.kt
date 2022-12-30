package com.invoice.contratista.domain.usecase.customer

import com.invoice.contratista.data.source.api.models.response.customer.CustomerResponse
import com.invoice.contratista.data.source.shared_preferences.UserManager
import com.invoice.contratista.domain.repository.CustomerRepository
import com.invoice.contratista.utils.Json.toObject
import com.invoice.contratista.utils.Resource
import javax.inject.Inject

class GetCustomersUseCase @Inject constructor(
    private val remoteRepository: CustomerRepository,
    private val userManager: UserManager
) {
    suspend operator fun invoke(): Resource<List<CustomerResponse>> {
        val customerResponse =
            remoteRepository.getCustomer(userManager.getToken(userManager.getToken(userManager.getUsername())))
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