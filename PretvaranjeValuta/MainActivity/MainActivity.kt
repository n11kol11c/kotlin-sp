package com.example.pretvaracnovca

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
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

        var polje_za_ispis = findViewById<TextView>(R.id.textView)
        var polje_za_upis = findViewById<EditText>(R.id.editTextText)
        val dugme = findViewById<Button>(R.id.button)
        val grupaOd = findViewById<RadioGroup>(R.id.radioGroupOd)
        val grupaDo = findViewById<RadioGroup>(R.id.radioGroupDo)

        val valute = mapOf(
            "EUR" to 1.0,
            "USD" to 1.08,
            "BAM" to 1.95583
        )

        fun konvertuj(iz: String, u: String, iznos: Double): Double {
            val vrijednostIz = valute[iz] ?: return 0.0
            val vrijednostU = valute[u] ?: return 0.0

            val uEur = iznos / vrijednostIz
            return uEur * vrijednostU
        }

        dugme.setOnClickListener {
            val tekst = polje_za_upis.text.toString()

            if (tekst.isEmpty()) {
                polje_za_ispis.text = "Unesite iznos!"
                return@setOnClickListener
            }

            val iznos = tekst.toDoubleOrNull()
            if (iznos == null) {
                polje_za_ispis.text = "Unesite validan broj!"
                return@setOnClickListener
            }

            val idOd = grupaOd.checkedRadioButtonId
            val idDo = grupaDo.checkedRadioButtonId

            if (idOd == -1 || idDo == -1) {
                polje_za_ispis.text = "Izaberite obje valute"
                return@setOnClickListener
            }

            val radioOd = findViewById<RadioButton>(idOd)
            val radioDo = findViewById<RadioButton>(idDo)

            val valutaOd = radioOd.text.toString()
            val valutaDo = radioDo.text.toString()

            val rezultat = konvertuj(valutaOd, valutaDo, iznos)

            polje_za_ispis.text = "Rezultat: %.2f".format(rezultat)
        }

    }
}
