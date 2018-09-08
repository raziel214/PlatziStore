package com.johnquimbaya.platzistore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Adapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcViewLanding.layoutManager=GridLayoutManager(this,2)

        val itemsShop=(0..20).map{
            Itemlanding("Titulo $it","Descr $it",200.00 + it)
        }

        val adapter= AdapterLanding(itemsShop)
        rcViewLanding.adapter=adapter


    }
}
