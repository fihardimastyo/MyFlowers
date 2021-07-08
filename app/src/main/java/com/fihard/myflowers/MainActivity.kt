package com.fihard.myflowers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sukulen)

        val sukulen : ImageButton = findViewById(R.id.sukulen1)


        sukulen.setOnClickListener{
            startActivity(Intent(this, Sukulen::class.java))
        }


    }
}