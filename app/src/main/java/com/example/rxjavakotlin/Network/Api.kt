package com.example.rxjavakotlin.Network

import com.example.rxjavakotlin.Model.Food
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface Api {

    @GET("food.php")
    fun getAllData(): Observable<List<Food>>
}