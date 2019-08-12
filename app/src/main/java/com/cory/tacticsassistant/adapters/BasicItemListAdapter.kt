package com.cory.tacticsassistant.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cory.tacticsassistant.R
import com.cory.tacticsassistant.fragments.PreviewFragment
import com.cory.tacticsassistant.models.EquipItem

class BasicItemHolder(itemView: View, private val mBasicItemListAdapter: BasicItemListAdapter?,
                      private val mPreviewFragment: PreviewFragment) : RecyclerView.ViewHolder(itemView),View.OnClickListener{
    private var mEquipItem: EquipItem? = null
    private val mImageView:ImageView = itemView.findViewById(R.id.image)
    private val mTextView:TextView = itemView.findViewById(R.id.text)

    fun bind(equipItem: EquipItem?){
        mEquipItem=equipItem
        mImageView.setImageBitmap(mEquipItem?.mImageBitmap?:EquipItem.sEmptyGridBitmap)
        mTextView.text = mEquipItem?.mAmount.toString()
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(mBasicItemListAdapter!=null){
            val list= mBasicItemListAdapter.mList
            for(i in 0 until list.size){
                if (list[i]==null){
                    list[i]=mEquipItem
                    mBasicItemListAdapter.notifyItemChanged(i)
                    return
                }
            }
            mPreviewFragment.startWarningAnim()
        }
    }
}

class BasicItemListAdapter(val mList:MutableList<EquipItem?>, private val mContext:Context,
                           private val mBasicItemListAdapter: BasicItemListAdapter?,
                           private val mPreviewFragment: PreviewFragment) : RecyclerView.Adapter<BasicItemHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicItemHolder {
        val inflater=LayoutInflater.from(mContext)
        return BasicItemHolder(
            inflater.inflate(
                R.layout.itemview_basic_item,
                parent,
                false
            ),
            mBasicItemListAdapter,
            mPreviewFragment
        )
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: BasicItemHolder, position: Int) {
        holder.bind(mList[position])
    }

}