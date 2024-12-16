package com.ramsey.allware

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MoreActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_more)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Morebutton
        val gotosoftwaredetails = findViewById<Button>(R.id.softwaredetails) as Button
        gotosoftwaredetails.setOnClickListener {
            val x = Intent(applicationContext, SoftwareDetailsActivity::class.java)
            startActivity(x)

            //Morebutton
            val gotohardwaredetails = findViewById<Button>(R.id.hardwaredetails) as Button
            gotohardwaredetails.setOnClickListener {
                val x = Intent(applicationContext, HardwareDetailsActivity::class.java)
                startActivity(x)
            }
        }
    }
}