package com.example.memeshare

import android.content.Intent
import android.graphics.drawable.Drawable
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.RequestListener as RequestListener1

class MainActivity : AppCompatActivity() {

    var memberString : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadMeme()
    }

    private fun loadMeme(){
        val imageview:ImageView = findViewById<ImageView>(R.id.imageview)
        val button = findViewById<Button>(R.id.share)
        button.isClickable = true;
        val textView = findViewById<TextView>(R.id.textView)
        textView.visibility = View.GONE
        val progressBar = findViewById<ProgressBar>(R.id.progressbar)
        progressBar.visibility = View.VISIBLE
// Instantiate the RequestQueue.
         memberString = "https://meme-api.herokuapp.com/gimme"

// Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, memberString, null,
                { response ->
                   memberString =  response.getString("url")
                    imageview.visibility = View.VISIBLE
                    textView.visibility = View.GONE
                    Glide.with(this).load(memberString).listener(object : RequestListener1<Drawable>{
                        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                            progressBar.visibility = View.GONE
                            return false;
                        }

                        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                            progressBar.visibility = View.GONE
                            return false;
                        }

                    }).into(imageview)
                },
                { error ->

                    progressBar.visibility = View.GONE
                    imageview.visibility = View.GONE
                    textView.visibility = View.VISIBLE
                    button.isClickable = false;
                    textView.setText("No internet\n" +
                            "Try:\n" +
                            "\n" +
                            "Checking the network cables, modem, and router\n" +
                            "Reconnecting to Wi-Fi\n" +
                            "Running Windows Network Diagnostics\n" +
                            "ERR_INTERNET_DISCONNECTED")
                }
        )

// Add the request to the RequestQueue.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)

    }

     fun nextButton(view : View){

        loadMeme()

    }

    fun shareButton(view: View) {

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plane"
        intent.putExtra(Intent.EXTRA_TEXT,"Hey! Awanish has just send you a good meme Plz Check $memberString")
        val chooser = Intent.createChooser(intent , "share this meme using ...")
        startActivity(chooser)

    }
}