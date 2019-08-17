package com.cory.tacticsassistant.models

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.cory.tacticsassistant.R

open class BasicItem {
    val mDescription: String
    val mImageBitmap: Bitmap?
    var mAmount: Int
    val mBasicName:Name?

    protected constructor(
        mDescription: String,
        mImageBitmap: Bitmap?,
        mAmount: Int,
        mName: Name?
    ) {
        this.mDescription = mDescription
        this.mImageBitmap = mImageBitmap
        this.mAmount = mAmount
        this.mBasicName = mName
    }

    enum class Name(val index:Int) {
        BF_SWORD(0),
        CHAIN_VEST(1),
        GIANT_S_BELT(2),
        NEEDLESSLY_LARGE_ROD(3),
        NEGATRON_CLOAK(4),
        RECURVE_BOW(7),
        SPATULA(6),
        TEAR_OF_THE_GODDESS(5)
    }

    companion object{
        private const val ITEM_AMOUNT=8
        private val sBitmaps=Array<Bitmap?>(ITEM_AMOUNT){null}
        private val sDescriptions= Array(ITEM_AMOUNT){""}
        var sEmptyGridBitmap:Bitmap?=null

        fun init(context:Context){
            sEmptyGridBitmap=BitmapFactory.decodeResource(context.resources,R.drawable.empty_grid)

            var i=0
            sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.bf_sword)
            sDescriptions[i++]=""
            sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.chain_vest)
            sDescriptions[i++]=""
            sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.giant_s_belt)
            sDescriptions[i++]=""
            sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.needlessly_large_rod)
            sDescriptions[i++]=""
            sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.negatron_cloak)
            sDescriptions[i++]=""
            sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.recurve_bow)
            sDescriptions[i++]=""
            sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.spatula)
            sDescriptions[i++]=""
            sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.tear_of_the_goddess)
            sDescriptions[i]=""
        }

        fun initEquipment(name: Name):BasicItem=
            BasicItem(sDescriptions[name.index], sBitmaps[name.index], 1, name)

        fun getBitmap(name:Name): Bitmap? {
            return sBitmaps[name.index]
        }
    }
}