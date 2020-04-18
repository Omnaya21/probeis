package com.ingyso.probeis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash : AppCompatActivity() {
    private val splashTime = 2000L
    private lateinit var myHandler : Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        myHandler = Handler()

        myHandler.postDelayed({
            goToMainActivity()
        }, splashTime)
    }

    private fun goToMainActivity() {
        //val entryActivityIntent = Intent(applicationContext, EntryActivity::class.java)
        val entryActivityIntent = Intent(applicationContext, IntroActivity::class.java)
        startActivity(entryActivityIntent)
        finish()
    }
}
