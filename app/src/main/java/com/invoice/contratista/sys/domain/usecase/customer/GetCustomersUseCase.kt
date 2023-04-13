package com.invoice.contratista.sys.domain.usecase.customer

import com.invoice.contratista.data.source.api.models.response.customer.CustomerResponse
import com.invoice.contratista.data.source.shared_preferences.UserManager
import com.invoice.contratista.sys.domain.repository.CustomerRepository
import com.invoice.contratista.utils.Resource
import javax.inject.Inject

class GetCustomersUseCase @Inject constructor(
    private val remoteRepository: CustomerRepository,
    private val userManager: UserManager,
) {
    suspend operator fun invoke(): Resource<List<CustomerResponse>> {
        val customerResponse = remoteRepository.getCustomer(userManager.token)
        return if (customerResponse.code() != 200) {
            Resource.error("different code")
        } else {
            val customer = customerResponse.body()!!
            if (!customer.status) Resource.success(emptyList())
            else Resource.success(customer.data)
        }
    }
}