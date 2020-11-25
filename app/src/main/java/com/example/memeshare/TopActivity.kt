package com.example.memeshare

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class TopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top)



    }

    fun channel(view: View){

        val uriUrl: Uri = Uri.parse("https://www.youtube.com/channel/UC4CwQWuy47lTFP8-RhtF8lw?view_as=subscriber")
        val launchBrowser = Intent(Intent.ACTION_VIEW, uriUrl)
        startActivity(launchBrowser)


    }

    fun meme(view: View){

        val intent = Intent(this, memesplash::class.java)
        startActivity(intent)
        finish()

    }

    fun aboutAwanish(view: View){

        val uriUrl: Uri = Uri.parse("https://awanishkumarsingh0.wixsite.com/coderbrains")
        val launchBrowser = Intent(Intent.ACTION_VIEW, uriUrl)
        startActivity(launchBrowser)
    }



}