package com.old_school_ratp.request.utils

import com.old_school_ratp.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private lateinit var apiService: ApiService

    fun getApiService(): ApiService {

        if (!::apiService.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(setupOkHttpClient())
                .build()

            apiService = retrofit.create(ApiService::class.java)
        }

        return apiService
    }

    private fun setupOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .build()
    }
}