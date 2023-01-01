package com.invoice.contratista.sys.domain.usecase.customer

import android.content.Context
import com.invoice.contratista.R
import com.invoice.contratista.data.mapper.toAddressEntity
import com.invoice.contratista.data.mapper.toCustomerEntity
import com.invoice.contratista.data.repository.local.AddressRepository
import com.invoice.contratista.data.repository.local.CustomerRepository
import com.invoice.contratista.utils.Constants
import com.invoice.contratista.utils.Resource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SaveCustomersUseCase @Inject constructor(
    private val customerRepository: CustomerRepository,
    private val addressRepository: AddressRepository,
    private val getCustomersUseCase: GetCustomersUseCase,
    @ApplicationContext private val context: Context
) {
    suspend operator fun invoke(token: String, function: (Resource<Void>) -> Unit) {
        val customersUseCase = getCustomersUseCase(token)
        return if (customersUseCase.status == Constants.Status.Failure) function.invoke(
            Resource.error(
                customersUseCase.exception!!
            )
        ) else {
            val customerResponses = customersUseCase.data!!
            if (customerResponses.isEmpty())
                function.invoke(Resource.error(context.getString(R.string.empty_list)))
            else {
                customerRepository.deleteCustomers()
                addressRepository.deleteAddress()
                customerResponses.forEach { customerResponse ->
                    customerRepository.setCustomer(customerResponse.toCustomerEntity())
                    addressRepository.setAddress(
                        customerResponse.address.toAddressEntity(
                            customerResponse.id
                        )
                    )
                    function.invoke(Resource.success(null))
                }
            }
        }
    }
}