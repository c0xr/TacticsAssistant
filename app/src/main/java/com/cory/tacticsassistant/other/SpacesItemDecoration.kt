package com.cory.tacticsassistant.other

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cory.tacticsassistant.models.BasicItem
import com.cory.tacticsassistant.models.UpgradedItem


class SpacesItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        if (parent.getChildLayoutPosition(view) %2==0) {
            outRect.left = space
        } else {
            outRect.left = space/2
        }

        if (parent.getChildLayoutPosition(view) <=1) {
            outRect.top = space
        } else {
            outRect.top = 0
        }

        if (parent.getChildLayoutPosition(view) %2==1) {
            outRect.right = space
        } else {
            outRect.right = space/2
        }

        outRect.bottom = space
    }
}