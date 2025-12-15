package com.example.imageviewbox

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
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
        val slika1 = findViewById<ImageView>(R.id.imageView)
        val slika2 = findViewById<ImageView>(R.id.imageView2)
        val slika3 = findViewById<ImageView>(R.id.imageView3)

        val cek = findViewById<CheckBox>(R.id.checkBox)

        slika1.visibility = View.GONE
        slika2.visibility = View.GONE
        slika3.visibility = View.GONE

        cek.setOnCheckedChangeListener { _, isChecked ->
            if (cek.isChecked) {
                slika1.visibility = View.VISIBLE
                slika2.visibility = View.VISIBLE
                slika3.visibility = View.VISIBLE
            } else {
                slika1.visibility = View.GONE
                slika2.visibility = View.GONE
                slika3.visibility = View.GONE
            }
        }
    }
}
