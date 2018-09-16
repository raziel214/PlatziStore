package com.johnquimbaya.platzistore

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class AdapterCart(val data:List<ItemLanding>):RecyclerView.Adapter<AdapterCart.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder=
            Holder(ItemList().createView(AnkoContext.
                    Companion.create(parent!!.
                    context,this,false)))
    override fun onBindViewHolder(holder: Holder, position: Int) {

    }
    override fun getItemCount(): Int =data.size

    class Holder(itemView:View):RecyclerView.ViewHolder(itemView){

        val txtViewTitle by lazy {
            itemView.find<TextView>(R.id.textTitleItem)
        }
        val txtViewdesc by lazy {
            itemView.find<TextView>(R.id.textDescItem)
        }
        val txtViewPrice by lazy {
            itemView.find<TextView>(R.id.textPriceItem)
        }

        fun bindView(data: ItemLanding){

            with(data){
                txtViewTitle.text = name
                txtViewdesc.text = gender
                txtViewPrice.text = mass
            }


        }




    }

}