package com.johnquimbaya.platzistore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_description.*
import kotlinx.android.synthetic.main.item_landing.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent?.extras?.let {
            txtDetailTitle.text=it.getString("title")
            txtDetailDesc.text=it.getString("desc")
            txtDetailPrice.text="$ ${String.format("%.2f", it.getDouble("price"))}"
        }

       // intent?.let{
       //     val textFromMain:String = it.extras.getString("text")
        //    textDetail.text = textFromMain
       // }


    }
}
