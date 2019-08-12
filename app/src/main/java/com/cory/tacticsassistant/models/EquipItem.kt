package com.cory.tacticsassistant.models

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.cory.tacticsassistant.R

class EquipItem private constructor(val mDescription:String, val mImageBitmap: Bitmap?, var mAmount:Int) {
    enum class Name {
        BF_SWORD,
        RECURVE_BOW,
        NEEDLESSLY_LARGE_ROD,
        TEAR_OF_THE_GODDESS,
        GIANT_S_BELT,
        CHAIN_VEST,
        NEGATRON_CLOAK,
        SPATULA
    }

    companion object{
        private val sBitmaps=Array<Bitmap?>(8){null}
        private val sDescriptions= Array(8){""}
        var sEmptyGridBitmap:Bitmap?=null

        fun init(context:Context){
            sEmptyGridBitmap=BitmapFactory.decodeResource(context.resources,R.drawable.empty_grid)
            sBitmaps[0]=BitmapFactory.decodeResource(context.resources,R.drawable.bf_sword)
            sBitmaps[1]=BitmapFactory.decodeResource(context.resources,R.drawable.recurve_bow)
            sBitmaps[2]=BitmapFactory.decodeResource(context.resources,R.drawable.needlessly_large_rod)
            sBitmaps[3]=BitmapFactory.decodeResource(context.resources,R.drawable.tear_of_the_goddess)
            sBitmaps[4]=BitmapFactory.decodeResource(context.resources,R.drawable.giant_s_belt)
            sBitmaps[5]=BitmapFactory.decodeResource(context.resources,R.drawable.chain_vest)
            sBitmaps[6]=BitmapFactory.decodeResource(context.resources,R.drawable.negatron_cloak)
            sBitmaps[7]=BitmapFactory.decodeResource(context.resources,R.drawable.spatula)
            sDescriptions[0]=""
            sDescriptions[1]=""
            sDescriptions[2]=""
            sDescriptions[3]=""
            sDescriptions[4]=""
            sDescriptions[5]=""
            sDescriptions[6]=""
            sDescriptions[7]=""
        }

        fun initEquipment(name:Name):EquipItem=
            when(name){
                Name.BF_SWORD-> EquipItem(sDescriptions[0], sBitmaps[0],1)
                Name.RECURVE_BOW -> EquipItem(sDescriptions[1], sBitmaps[1],1)
                Name.NEEDLESSLY_LARGE_ROD -> EquipItem(sDescriptions[2], sBitmaps[2],1)
                Name.TEAR_OF_THE_GODDESS -> EquipItem(sDescriptions[3], sBitmaps[3],1)
                Name.GIANT_S_BELT -> EquipItem(sDescriptions[4], sBitmaps[4],1)
                Name.CHAIN_VEST -> EquipItem(sDescriptions[5], sBitmaps[5],1)
                Name.NEGATRON_CLOAK -> EquipItem(sDescriptions[6], sBitmaps[6],1)
                Name.SPATULA -> EquipItem(sDescriptions[7], sBitmaps[7],1)
            }
    }
}