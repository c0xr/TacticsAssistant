package com.cory.tacticsassistant.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cory.tacticsassistant.R
import com.cory.tacticsassistant.models.EquipItem

class UpgradedItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

    fun bind(equipItem: EquipItem?){

    }

    override fun onClick(v: View?) {

    }
}

class UpgradedItemListAdapter(val mList:MutableList<EquipItem?>, private val mContext: Context) :
        RecyclerView.Adapter<UpgradedItemHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpgradedItemHolder {
        val inflater= LayoutInflater.from(mContext)
        return UpgradedItemHolder(
            inflater.inflate(
                R.layout.itemview_upgraded_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: UpgradedItemHolder, position: Int) {
        holder.bind(mList[position])
    }

}