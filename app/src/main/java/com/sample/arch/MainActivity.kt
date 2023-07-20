package com.sample.arch

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.sample.arch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var biding: ActivityMainBinding

    override fun onCreateView(
        parent: View?,
        name: String,
        context: Context,
        attrs: AttributeSet
    ): View? {
        return super.onCreateView(parent, name, context, attrs)?.apply {
            biding = ActivityMainBinding.bind(this)
        }
    }
}