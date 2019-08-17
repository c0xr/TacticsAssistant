package com.cory.tacticsassistant.fragments

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.BounceInterpolator
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cory.tacticsassistant.R
import com.cory.tacticsassistant.adapters.BasicItemListAdapter
import com.cory.tacticsassistant.adapters.UpgradedItemListAdapter
import com.cory.tacticsassistant.models.BasicItem
import com.cory.tacticsassistant.models.UpgradedItem
import com.cory.tacticsassistant.other.SpacesItemDecoration

class PreviewFragment: Fragment() {
    private val mRepositoryList= MutableList<BasicItem?>(8){null}
    private var mRepositoryText:TextView?=null
    private var mWarningText:TextView?=null
    private var mAnimSet:AnimatorSet?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.fragment_preview,container,false)
        val pickerRecyclerView=view.findViewById<RecyclerView>(R.id.picker_recyclerview)
        val repositoryRecyclerView=view.findViewById<RecyclerView>(R.id.repository_recyclerview)
        val resultRecyclerView=view.findViewById<RecyclerView>(R.id.result_recyclerview)
        mRepositoryText=view.findViewById(R.id.repository_textview)
        mWarningText=view.findViewById(R.id.warning_textview)

        BasicItem.init(activity!!)
        UpgradedItem.init(activity!!)
        mAnimSet=initAnim()

        resultRecyclerView.adapter=UpgradedItemListAdapter(emptyList<UpgradedItem>().toMutableList(), activity!!)
        resultRecyclerView.layoutManager=LinearLayoutManager(activity)

        repositoryRecyclerView.adapter=BasicItemListAdapter(
            mRepositoryList,
            activity!!,
            null,
            resultRecyclerView.adapter as UpgradedItemListAdapter?,
            this
        )
        repositoryRecyclerView.layoutManager=GridLayoutManager(activity,2)

        pickerRecyclerView.adapter=BasicItemListAdapter(
            getPickerList(),
            activity!!,
            repositoryRecyclerView.adapter as BasicItemListAdapter,
            resultRecyclerView.adapter as UpgradedItemListAdapter?,
            this
        )
        pickerRecyclerView.layoutManager=GridLayoutManager(activity,2)

        val spacingInPixels= resources.getDimensionPixelSize(R.dimen.picker_inner_margin)
        repositoryRecyclerView.addItemDecoration(SpacesItemDecoration(spacingInPixels))
        pickerRecyclerView.addItemDecoration(SpacesItemDecoration(spacingInPixels))

        return view
    }

    private fun getPickerList(): MutableList<BasicItem?> {
        val list= emptyList<BasicItem?>().toMutableList()
        for (name in BasicItem.Name.values()){
            list.add(BasicItem.initEquipment(name))
        }
        return list
    }

    @SuppressLint("ObjectAnimatorBinding")
    private fun initAnim():AnimatorSet{
        val set=AnimatorSet()

        val oa=ObjectAnimator.ofFloat(mRepositoryText,"alpha",0f)
        oa.duration=200

        val oa2=ObjectAnimator.ofFloat(mWarningText,"alpha",1f)
        oa2.duration=200

        val oa3=ObjectAnimator.ofFloat(mWarningText,"translationY",0f,-30f)
        oa3.duration=200

        val oa4=ObjectAnimator.ofFloat(mWarningText,"translationY",-30f,0f)
        oa4.interpolator=BounceInterpolator()
        oa4.duration=200

        val oa5=ObjectAnimator.ofFloat(mRepositoryText,"alpha",1f)
        oa5.duration=200
        oa5.startDelay=500

        val oa6=ObjectAnimator.ofFloat(mWarningText,"alpha",0f)
        oa6.duration=200
        oa6.startDelay=500

        set.play(oa)
            .with(oa2)
            .before(oa3)
        set.play(oa3)
            .before(oa4)
        set.play(oa4)
            .before(oa5)
        set.play(oa5)
            .with(oa6)

        return set
    }

    fun startWarningAnim(){
        if(mAnimSet?.isRunning?:true){
            return
        }
        mAnimSet?.start()
    }
}