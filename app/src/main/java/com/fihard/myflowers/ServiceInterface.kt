package com.fihard.myflowers

import retrofit2.Call
import retrofit2.http.*

interface  ServiceInterface {
    @GET("Tanaman")
    fun getData(): Call<List<DataTanaman>>



}
