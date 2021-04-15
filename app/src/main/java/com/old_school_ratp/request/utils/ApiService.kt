package com.old_school_ratp.request.utils

import com.old_school_ratp.request.lines.Lines
import com.old_school_ratp.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET(Constants.LINES + Constants.TYPE)
    fun getMetroLines(@Path("type") metro: String): Call<Lines>
}
