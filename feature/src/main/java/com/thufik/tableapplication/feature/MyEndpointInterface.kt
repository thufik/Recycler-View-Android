package com.thufik.tableapplication.feature

import retrofit2.http.GET

public interface MyEndpointInterface {

    @GET("animals")
    fun getAnimals(){

    }

}