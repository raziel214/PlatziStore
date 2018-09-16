package com.johnquimbaya.platzistore

import com.johnquimbaya.platzistore.pojosretrofit.ResponseProducts
import com.johnquimbaya.platzistore.pojosretrofit.ResultsItem
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET

interface Endpoints {

    @GET(   "people/")
    fun getPeople(): Call<ResponseProducts>
    
}