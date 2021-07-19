package com.fihard.myflowers

import retrofit2.Call
import retrofit2.http.*

interface  ServiceInterface3 {
    @GET("Tanaman")
    fun getData(): Call<List<DataTanaman3>>



}
