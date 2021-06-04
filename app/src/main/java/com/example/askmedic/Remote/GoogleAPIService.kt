package com.example.askmedic.Remote

import retrofit2.Call
import com.example.askmedic.Model.MyPlaces
import retrofit2.http.GET
import retrofit2.http.Url

interface GoogleAPIService {
    @GET
    fun getNearbyPlaces (@Url url:String): Call<MyPlaces>
}