package com.example.middleterm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.middleterm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)

        btn1.setOnClickListener{
            val intent = Intent(this, activity_btn1::class.java)
            startActivity(intent)
        }

        btn2.setOnClickListener{
            val intent = Intent(this, activity_btn2::class.java)
            startActivity(intent)
        }
    }
}