package com.invoice.contratista.data.api.retrofit

import com.invoice.contratista.data.api.models.DataResponse
import com.invoice.contratista.data.api.models.customer.CustomerResponse
import com.invoice.contratista.data.api.models.product.ProductResponse
import com.invoice.contratista.utils.Constants
import retrofit2.Response
import javax.inject.Inject

class HelperImp @Inject constructor(private val service: Service) : Helper {

    override suspend fun getProducts(): Response<DataResponse<ProductResponse>> =
        service.getProducts(Constants.TOKEN)

    override suspend fun getCustomer(): Response<DataResponse<CustomerResponse>> =
        service.getCustomer(Constants.TOKEN)

}