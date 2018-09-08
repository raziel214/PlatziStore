package com.johnquimbaya.platzistore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.Adapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcView.layoutManager= LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false)

        val items= arrayListOf<ItemListPojo>()

        (0..20).map {
            items.add(ItemListPojo("Titulo $it",
                    "Descripcion $it","200"))
        }

        rcView.adapter=AdaptadorCarrito(items)



    }
}
