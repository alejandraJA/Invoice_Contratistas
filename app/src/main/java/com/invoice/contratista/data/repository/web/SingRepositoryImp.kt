package com.invoice.contratista.data.repository.web

import com.invoice.contratista.data.source.api.models.request.SingRequest
import com.invoice.contratista.data.source.api.models.request.UpdateTokenRequest
import com.invoice.contratista.data.source.api.models.response.ResponseApi
import com.invoice.contratista.data.source.api.models.response.TokenModel
import com.invoice.contratista.data.source.api.models.response.UserModel
import com.invoice.contratista.data.source.api.retrofit.Service
import com.invoice.contratista.sys.domain.repository.SingRepository
import retrofit2.Response
import javax.inject.Inject

class SingRepositoryImp @Inject constructor(private val service: Service) : SingRepository {
    override suspend fun singIn(request: SingRequest): Response<ResponseApi<TokenModel?>> =
        service.singIn(request)

    override suspend fun updateToken(request: UpdateTokenRequest):
            Response<ResponseApi<TokenModel>> = service.updateToken(request)

    override suspend fun singUp(request: SingRequest) = service.singUp(request)
}