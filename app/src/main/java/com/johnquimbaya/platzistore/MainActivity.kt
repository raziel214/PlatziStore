package com.johnquimbaya.platzistore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Adapter
import com.johnquimbaya.platzistore.pojosretrofit.ResponseProducts
import com.johnquimbaya.platzistore.pojosretrofit.ResultsItem
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Request
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rcViewLanding.layoutManager= GridLayoutManager(this,2) as RecyclerView.LayoutManager?

        val retrofit= Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val ednpoint=retrofit.create(Endpoints::class.java)

        val call= ednpoint.getPeople()

        call.enqueue(object : Callback<ResponseProducts> {
            override fun onFailure(call: Call<ResponseProducts>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseProducts>, response: Response<ResponseProducts>) {
                if (response?.code()==200){
                    Log.e("Respuesta","${response.body().toString()}")

                    llenarRecycler(response.body()?.results)
                }
            }


        })





       /* val itemsShop=(0..20).map{
            ItemLanding("Titulo $it","Descr $it",200.00 + it,"")
        }

        val adapter= AdapterLanding(itemsShop)
        rcViewLanding.adapter=adapter*/


    }

    private fun llenarRecycler(results: List<ResultsItem?>?) {

        val productos =results?.map {
            it?.let { (_, height, gender, _, _, _, mass, _, _, _, _, _, _, _, name) ->
                ItemLanding(name?:"", mass?:"", height?:"",gender?:"")
            }


        }

        rcViewLanding.adapter=AdapterLanding(productos)

    }
}
