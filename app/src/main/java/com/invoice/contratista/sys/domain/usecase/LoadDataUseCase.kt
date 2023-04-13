package com.invoice.contratista.sys.domain.usecase

import com.invoice.contratista.sys.domain.usecase.customer.SaveCustomersUseCase
import com.invoice.contratista.sys.domain.usecase.product.SaveProductsUseCase
import com.invoice.contratista.utils.Constants
import javax.inject.Inject

class LoadDataUseCase @Inject constructor(
    private val saveProductsUseCase: SaveProductsUseCase,
    private val saveCustomersUseCase: SaveCustomersUseCase
) {
    suspend operator fun invoke(function: (String) -> Unit) {
        saveCustomersUseCase { resource ->
            if (resource.status == Constants.Status.Failure) function.invoke(resource.exception!!)
        }
        saveProductsUseCase { resource ->
            if (resource.status == Constants.Status.Failure) function.invoke(resource.exception!!)
        }
        function.invoke("")
    }
}