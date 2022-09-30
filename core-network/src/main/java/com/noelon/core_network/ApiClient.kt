package com.noelon.core_network

import com.noelon.core_network.models.BaseResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface ApiClient {
    @GET("api")
    suspend fun getUserDetails() : ApiResponse<BaseResponse>
}