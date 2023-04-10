package com.invoice.contratista.sys.domain.repository

import com.invoice.contratista.data.source.api.models.request.SingRequest
import com.invoice.contratista.data.source.api.models.request.UpdateTokenRequest
import com.invoice.contratista.data.source.api.models.response.ResponseApi
import com.invoice.contratista.data.source.api.models.response.TokenModel
import com.invoice.contratista.data.source.api.models.response.UserModel
import retrofit2.Response

interface SingRepository {
    suspend fun singIn(request: SingRequest): Response<ResponseApi<TokenModel?>>
    suspend fun updateToken(request: UpdateTokenRequest): Response<ResponseApi<TokenModel>>
    suspend fun singUp(request: SingRequest): Response<ResponseApi<UserModel>>
}