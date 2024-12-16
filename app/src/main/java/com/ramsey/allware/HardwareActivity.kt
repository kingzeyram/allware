package com.ramsey.allware

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ramsey.swalaemployeeapp.ApiHelper
import org.json.JSONObject

class HardwareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hardware)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Find views by id
        val id_number = findViewById<EditText>(R.id.idnumber) as EditText
        val username = findViewById<EditText>(R.id.username) as EditText
        val condition = findViewById<EditText>(R.id.condition) as EditText
        val budget = findViewById<EditText>(R.id.budget) as EditText
        val type = findViewById<EditText>(R.id.type) as EditText


        //post
        val postbtn = findViewById<Button>(R.id.btnPost) as Button
        postbtn.setOnClickListener {


            val Body = JSONObject()
            //Update with json -key value

            Body.put("department", id_number.text.toString())
            Body.put("username", username.text.toString())
            Body.put("condition", condition.text.toString())
            Body.put("budget", budget.text.toString())
            Body.put("type", type.text.toString())
            //call helper
            val api = "https://swalamodcom.pythonanywhere.com/employee"

            val helper = ApiHelper(applicationContext)
            helper.post(api, Body)
        }

    }
}