package com.cory.tacticsassistant.models

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.cory.tacticsassistant.R

class UpgradedItem private constructor(
    mDescription: String,
    mImageBitmap: Bitmap?,
    mAmount: Int,
    val mSubItemA: BasicItem.Name,
    val mSubItemB: BasicItem.Name,
    val mUpgradedName:Name
) : BasicItem(mDescription, mImageBitmap, mAmount, null) {

    enum class Name(val index:Int){
        BLADE_OF_THE_RUINED_KING(0),
        DARKIN(1),
        DERVISH_BLADE(2),
        DRAGON_S_CLAW(3),
        FORCE_OF_NATURE(4),
        FROZEN_HEART(5),
        FROZEN_MALLET(6),
        GUARDIAN_ANGEL(7),
        GUINSOO_S_RAGEBLADE(8),
        HEXTECH_GUNBLADE(9),
        HUSH(10),
        INFINITY_EDGE(11),
        IONIC_SPARK(12),
        KNIGHT_S_VOW(13),
        LOCKET_OF_THE_IRON_SOLARI(14),
        LUDEN_S_ECHO(15),
        MORELLONOMICON(16),
        PHANTOM_DANCER(17),
        RABADON_S_DEATHCAP(18),
        RAPID_FIRECANNON(19),
        RED_BUFF(20),
        REDEMPTION(21),
        RUNAAN_S_HURRICANE(22),
        SERAPH_S_EMBRACE(23),
        SPACE_BLOODTHIRSTER(24),
        SPEAR_OF_SHOJIN(25),
        STATIKK_SHIV(26),
        SWORD_BREAKER(27),
        SWORD_OF_THE_DIVINE(28),
        THORNMAIL(29),
        TITANIC_HYDRA(30),
        WARMOG_S_ARMOR(31),
        YOUMUU_S_GHOSTBLADE(32),
        YUMMI(33),
        ZEKE_S_HERALD(34),
        ZEPHYR(35)
    }

    companion object{
        private const val ITEM_AMOUNT=36
        private val sBitmaps=Array<Bitmap?>(ITEM_AMOUNT){null}
        private val sDescriptions= Array(ITEM_AMOUNT){""}
        private val MATCH_RESULT= arrayOf(
            arrayOf(Name.INFINITY_EDGE,Name.GUARDIAN_ANGEL,Name.ZEKE_S_HERALD,Name.HEXTECH_GUNBLADE,
                Name.SPACE_BLOODTHIRSTER,Name.SWORD_OF_THE_DIVINE,Name.YOUMUU_S_GHOSTBLADE,Name.SPEAR_OF_SHOJIN),

            arrayOf(Name.GUINSOO_S_RAGEBLADE,Name.THORNMAIL,Name.RED_BUFF,Name.LOCKET_OF_THE_IRON_SOLARI,
                Name.SWORD_BREAKER,Name.PHANTOM_DANCER,Name.KNIGHT_S_VOW,Name.FROZEN_HEART),

            arrayOf(Name.ZEKE_S_HERALD,Name.RED_BUFF,Name.WARMOG_S_ARMOR,Name.MORELLONOMICON,
                Name.ZEPHYR, Name.TITANIC_HYDRA,Name.FROZEN_MALLET,Name.REDEMPTION),

            arrayOf(Name.HEXTECH_GUNBLADE,Name.LOCKET_OF_THE_IRON_SOLARI,Name.MORELLONOMICON,Name.RABADON_S_DEATHCAP,
                Name.IONIC_SPARK,Name.GUINSOO_S_RAGEBLADE,Name.YUMMI,Name.LUDEN_S_ECHO),

            arrayOf(Name.SPACE_BLOODTHIRSTER,Name.SWORD_BREAKER,Name.ZEPHYR,Name.IONIC_SPARK,
                Name.DRAGON_S_CLAW,Name.DERVISH_BLADE,Name.RUNAAN_S_HURRICANE,Name.HUSH),

            arrayOf(Name.SWORD_OF_THE_DIVINE,Name.PHANTOM_DANCER,Name.TITANIC_HYDRA,Name.GUINSOO_S_RAGEBLADE,
                Name.DERVISH_BLADE,Name.RAPID_FIRECANNON,Name.BLADE_OF_THE_RUINED_KING,Name.STATIKK_SHIV),

            arrayOf(Name.YOUMUU_S_GHOSTBLADE,Name.KNIGHT_S_VOW,Name.FROZEN_MALLET,Name.YUMMI,
                Name.RUNAAN_S_HURRICANE,Name.BLADE_OF_THE_RUINED_KING,Name.FORCE_OF_NATURE,Name.DARKIN),

            arrayOf(Name.SPEAR_OF_SHOJIN,Name.FROZEN_HEART,Name.REDEMPTION,Name.LUDEN_S_ECHO,
                Name.HUSH,Name.STATIKK_SHIV,Name.DARKIN,Name.SERAPH_S_EMBRACE)
        )

        fun init(context:Context){
            var i=0
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.blade_of_the_ruined_king)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.darkin)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.dervish_blade)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.dragon_s_claw)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.force_of_nature)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.frozen_heart)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.frozen_mallet)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.guardian_angel)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.guinsoo_s_rageblade)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.hextech_gunblade)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.hush)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.infinity_edge)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.ionic_spark)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.knight_s_vow)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.locket_of_the_iron_solari)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.luden_s_echo)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.morellonomicon)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.phantom_dancer)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.rabadon_s_deathcap)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.rapid_firecannon)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.red_buff)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.redemption)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.runaan_s_hurricane)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.seraph_s_embrace)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.space_bloodthirster)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.spear_of_shojin)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.statikk_shiv)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.sword_breaker)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.sword_of_the_divine)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.thornmail)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.titanic_hydra)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.warmog_s_armor)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.youmuu_s_ghostblade)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.yummi)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.zeke_s_herald)
            UpgradedItem.sDescriptions[i++]=""
            UpgradedItem.sBitmaps[i]=BitmapFactory.decodeResource(context.resources,R.drawable.zephyr)
            UpgradedItem.sDescriptions[i]=""
        }

        fun initEquipment(name: Name,subItemA: BasicItem.Name,subItemB: BasicItem.Name):UpgradedItem=
            UpgradedItem(sDescriptions[name.index], sBitmaps[name.index],1,
                subItemA,subItemB,name)

        fun matchItems(subItemA:BasicItem.Name,subItemB:BasicItem.Name):Name{
            return MATCH_RESULT[subItemA.index][subItemB.index]
        }

        fun getMatchedList(list:MutableList<BasicItem?>):MutableList<UpgradedItem>{
            val result= emptyList<UpgradedItem>().toMutableList()
            var actualSize=list.size
            for(i in 0 until list.size){
                if(list[i]==null){
                    actualSize=i
                    break
                }
            }

            fun checkItem(itemName: Name):Boolean{
                for(i in 0 until result.size){
                    if(result[i].mUpgradedName==itemName){
                        return true
                    }
                }
                return false
            }

            for(i in 0 until actualSize){
                for (j in i + 1 until actualSize) {

                    Log.d("TAGG",i.toString()+" "+j)
                    val upgraded=matchItems(list[i]!!.mBasicName!!, list[j]!!.mBasicName!!)
                    if(!checkItem(upgraded)){
                        result.add(
                            initEquipment(
                                upgraded,
                                list[i]!!.mBasicName!!,
                                list[j]!!.mBasicName!!
                            )
                        )
                    }else{
                        for(k in 0 until result.size){
                            if(result[k].mUpgradedName==upgraded){
                                result[k].mAmount++
                                break
                            }
                        }
                    }



                }
            }
            return result
        }
    }
}