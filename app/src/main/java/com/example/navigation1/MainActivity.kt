package com.example.navigation1

import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private lateinit var matchImage: ImageView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                Glide.with(this).load("https://cdn.pixabay.com/photo/2019/07/11/07/01/horse-4330166_640.jpg").into(matchImage)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                matchImage.setImageDrawable(null)
                animation_view.setAnimation(R.raw.favourite_app_icon)
                animation_view.playAnimation()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                textMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        textMessage = findViewById(R.id.message)
        matchImage = findViewById(R.id.match_image)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)



    }
}
