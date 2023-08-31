package com.sample.arch

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.sample.arch.databinding.ActivityMainBinding
import com.sample.feature.authentication.login.LoginFragment

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().apply {
            replace(
                biding.fragmentContainerView.id,
                LoginFragment(),
                LoginFragment::class.java.name
            )
        }.commit()
    }
}