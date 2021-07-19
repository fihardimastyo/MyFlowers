package com.fihard.myflowers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    lateinit var sukulen : ImageView
    lateinit var palem : ImageView
    lateinit var monstera :ImageView



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sukulen = findViewById(R.id.sukulen1)
        palem = findViewById(R.id.palm1)
        monstera = findViewById(R.id.monstera1)



        sukulen.setOnClickListener{

            val pindah = Intent (this, Sukulen::class.java)
            startActivity(pindah)

        }
        palem.setOnClickListener {

            val pindah = Intent(this, Palem::class.java)
            startActivity(pindah)
        }
        monstera.setOnClickListener {

            val pindah = Intent(this, Monstera::class.java)
            startActivity(pindah)
        }






    }
}