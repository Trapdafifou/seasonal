package com.example.elgrim.seasonal

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {
    val SPLASH_TIME : Long = 2500
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.splaschreenfinal)
        videoView.setVideoURI(uri)
        videoView.start()

        Handler().postDelayed({
            val intent = Intent(this, LoginManager::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME)
    }
}
