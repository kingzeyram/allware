package com.ramsey.allware

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //hardwarebutton
        val gotohardware = findViewById<Button>(R.id.hardware) as Button
        gotohardware.setOnClickListener {
            val x = Intent(applicationContext, HardwareActivity::class.java)
            startActivity(x)
        }

        //softwarebutton
        val gotosoftware = findViewById<Button>(R.id.software) as Button
        gotosoftware.setOnClickListener {
            val x = Intent(applicationContext, SoftwareActivity::class.java)
            startActivity(x)
        }

        //Morebutton
        val gotomore = findViewById<Button>(R.id.more) as Button
        gotomore.setOnClickListener {
            val x = Intent(applicationContext, MoreActivity::class.java)
            startActivity(x)
        }
    }
}