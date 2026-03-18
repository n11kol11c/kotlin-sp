package com.example.finaltest2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
        var unos = findViewById<EditText>(R.id.editTextText)
        var naslov = findViewById<TextView>(R.id.textView)
        val dugme1 = findViewById<Button>(R.id.button1)
        val dugme2 = findViewById<Button>(R.id.button2)
        val dugme3 = findViewById<Button>(R.id.button3)
        val dugme4 = findViewById<Button>(R.id.button4)
        val dugme5 = findViewById<Button>(R.id.button5)

        dugme1.setOnClickListener {
            val tekst_iz_polja = unos.text.toString()

            val intent = Intent(this, Class.forName("com.example.finaltest2.DrugaAktivnost"))
            intent.putExtra("IME", tekst_iz_polja)
            startActivity(intent)
        }

        dugme2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=Android"))
            startActivity(intent)
        }

        dugme3.setOnClickListener {

            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("smsto:123456789")

            intent.putExtra("sms_body", "Pozdrav iz Android aplikacije")

            startActivity(intent)
        }

        // dugme4.setOnClickListener {
        //     val intent = Intent(Intent.ACTION_DIAL)
        //     intent.data = Uri.parse("tel:123456")
        //     startActivity(intent)
        // }

        dugme4.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:primatelj@example.com")

            intent.putExtra(Intent.EXTRA_SUBJECT, "Pozdrav iz Android aplikacije")
            intent.putExtra(Intent.EXTRA_TEXT, "Ovo je automatski generisana poruka.")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        dugme5.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Niksic"))
            startActivity(intent)
        }
    }
}
