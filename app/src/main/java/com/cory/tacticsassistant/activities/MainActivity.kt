package com.cory.tacticsassistant.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.cory.tacticsassistant.R
import com.cory.tacticsassistant.fragments.PreviewFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm=supportFragmentManager
        val f=fm.findFragmentById(R.id.preview_fragment_container)

        if (f==null) {
            fm.beginTransaction()
                .add(R.id.preview_fragment_container,PreviewFragment())
                .commit()
        }
    }
}
