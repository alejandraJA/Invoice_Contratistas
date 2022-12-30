package com.invoice.contratista.domain.repository

import com.invoice.contratista.data.source.api.models.request.SingRequest
import com.invoice.contratista.data.source.api.models.request.UpdateTokenRequest
import com.invoice.contratista.data.source.api.models.response.TokenResponse
import com.invoice.contratista.utils.ResponseApi
import retrofit2.Response

interface SingRepository {
    suspend fun singIn(request: SingRequest): Response<ResponseApi<TokenResponse?>>
    suspend fun updateToken(request: UpdateTokenRequest): Response<ResponseApi<TokenResponse>>
}