package com.invoice.contratista.data.repository.web

import com.invoice.contratista.data.source.api.models.request.SingRequest
import com.invoice.contratista.data.source.api.models.request.UpdateTokenRequest
import com.invoice.contratista.data.source.api.models.response.TokenResponse
import com.invoice.contratista.data.source.api.retrofit.Service
import com.invoice.contratista.sys.domain.repository.SingRepository
import com.invoice.contratista.utils.ResponseApi
import retrofit2.Response
import javax.inject.Inject

class SingRepositoryImp @Inject constructor(private val service: Service) : SingRepository {
    override suspend fun singIn(request: SingRequest): Response<ResponseApi<TokenResponse?>> =
        service.singIn(request)

    override suspend fun updateToken(request: UpdateTokenRequest):
            Response<ResponseApi<TokenResponse>> = service.updateToken(request)

    override suspend fun singUp(request: SingRequest): Response<ResponseApi<Any?>> =
        service.singUp(request)
}