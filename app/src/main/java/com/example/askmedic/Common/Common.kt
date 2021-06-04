package com.example.askmedic.Common

import com.example.askmedic.Remote.GoogleAPIService
import com.example.askmedic.Remote.RetrofitClient


object Common {

    private val GOOGLE_API_URL = "https://maps.googleapis.com/"
    val googleApiService:GoogleAPIService
    get() = RetrofitClient.getClient(GOOGLE_API_URL).create(GoogleAPIService::class.java)

}