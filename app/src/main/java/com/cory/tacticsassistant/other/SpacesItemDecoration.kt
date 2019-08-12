package com.cory.tacticsassistant.other

import android.R.attr.top
import android.R.attr.bottom
import android.R.attr.right
import android.R.attr.left
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


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

        if (parent.getChildLayoutPosition(view) %2==1) {
            outRect.right = space
        } else {
            outRect.right = space/2
        }


        outRect.bottom = space

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildLayoutPosition(view) <=1) {
            outRect.top = space
        } else {
            outRect.top = 0
        }
    }
}