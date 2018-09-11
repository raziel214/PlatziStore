package com.johnquimbaya.platzistore

import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class ItemList : AnkoComponent<AdapterCart> {
    override fun createView(ui: AnkoContext<AdapterCart>): View = with(ui){
        verticalLayout{
            lparams(width= matchParent, height = wrapContent)
            cardView{
                linearLayout {
                    orientation= LinearLayout.HORIZONTAL
                    lparams(width= matchParent)
                    imageView(R.mipmap.ic_launcher){
                        R.id.imgItem
                        scaleType= ImageView.ScaleType.CENTER_CROP
                    }.lparams(width=dip(0),height = dip(100),weight = 1F)

                    linearLayout {
                        padding=dip(5)
                        orientation=LinearLayout.VERTICAL
                        textView("Titulo") {
                            id=R.id.textTitleItem
                            setTextAppearance(ctx, android.R.style.TextAppearance_Material_Large)

                        }
                        textView("Description") {
                            id=R.id.textDescItem
                            setTextAppearance(ctx, android.R.style.TextAppearance_Material_Small)

                        }
                        textView("Price") {
                            id=R.id.textPriceItem
                            setTextAppearance(ctx, android.R.style.TextAppearance_Material_Medium)
                            textColor = resources.getColor(R.color.colorAccent)

                        }.lparams{
                            topMargin=dip(5)
                            gravity=Gravity.END
                        }
                    }

                }
            }
        }
    }

}