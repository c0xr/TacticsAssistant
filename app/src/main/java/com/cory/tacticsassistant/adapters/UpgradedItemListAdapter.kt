package com.cory.tacticsassistant.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.cory.tacticsassistant.R
import com.cory.tacticsassistant.models.BasicItem
import com.cory.tacticsassistant.models.UpgradedItem

class UpgradedItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
    private var mUpgradedItem: UpgradedItem? = null
    private val mImageViewA:ImageView = itemView.findViewById(R.id.image_a)
    private val mImageViewB:ImageView = itemView.findViewById(R.id.image_b)
    private val mImageViewC:ImageView = itemView.findViewById(R.id.image_c)

    fun bind(upgradedItem:UpgradedItem?){
        mUpgradedItem=upgradedItem
        mImageViewA.setImageBitmap(mUpgradedItem?.mImageBitmap)
        mImageViewB.setImageBitmap(BasicItem.getBitmap(mUpgradedItem?.mSubItemA!!))
        mImageViewC.setImageBitmap(BasicItem.getBitmap(mUpgradedItem?.mSubItemB!!))
    }

    override fun onClick(v: View?) {

    }
}

class UpgradedItemListAdapter(var mList:MutableList<UpgradedItem>, private val mContext: Context) :
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