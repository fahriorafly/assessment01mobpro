package org.d3if0093.yelzstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_hitung_ukuran.*

class HitungUkuran : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung_ukuran)

        val actionBar = supportActionBar
        actionBar!!.title = "Temukan Ukuran Yang Cocok"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val hitButton: Button = findViewById(R.id.buttonHitung)
        hitButton.setOnClickListener { hitungUkuran() }

    }

    private fun hitungUkuran(): Int {
        val lebar = panjangEditText.text.toString().toFloat()
        val panjang = lebarEditText.text.toString().toFloat()
        val ukuran = lebar + panjang

        val selectedId = radioGroup.checkedRadioButtonId
        val isMale = selectedId == R.id.priaRadioButton

        hitung.text = getString(R.string.hasilUkuran)
        val stringRes = if (isMale) {
            when {
                ukuran < 100 -> R.string.s
                ukuran >= 100 -> R.string.m
                ukuran >= 27.0 -> R.string.l
                ukuran >= 27.0 -> R.string.xl
                ukuran >= 27.0 -> R.string.xxl
                else -> R.string.xxxl
            }
        } else {
            when {
                ukuran < 20.5 -> R.string.s
                ukuran >= 27.0 -> R.string.m
                ukuran >= 27.0 -> R.string.l
                ukuran >= 27.0 -> R.string.xl
                ukuran >= 27.0 -> R.string.xxl
                else -> R.string.xxxl
            }
        }
        return stringRes
    }
}