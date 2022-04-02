package org.d3if0093.yelzstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.button.MaterialButtonToggleGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val katalog = listOf(
        "Kaos",
        "Hoodie",
        "Crewneck",
        "Phone Case",
        "Cargo")
    private var index = 0
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            val intent = Intent(this, HitungUkuran::class.java)
            startActivity(intent)
        }

        val nextButton: Button = findViewById(R.id.nextButton)
        nextButton.setOnClickListener { showNext() }

        btn_theme.addOnButtonCheckedListener(object :MaterialButtonToggleGroup.OnButtonCheckedListener{
            override fun onButtonChecked(
                group: MaterialButtonToggleGroup?,
                selectedBtnId: Int,
                isChecked: Boolean
            ) {
                val theme = when(selectedBtnId){
                            R.id.btnDefault -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                            R.id.btnDark -> AppCompatDelegate.MODE_NIGHT_YES
                            else -> AppCompatDelegate.MODE_NIGHT_NO
                }
                Log.d(TAG, "isChecked:$isChecked theme:$theme")
                AppCompatDelegate.setDefaultNightMode(theme)
            }
        })
    }

    private fun showNext() {
        index = if (index == katalog.size-1) 0 else index + 1

        val imageView: ImageView = findViewById(R.id.imageView)
        val resourceId = when(index) {
            0 -> R.drawable.kaos
            1 -> R.drawable.hoodie
            2 -> R.drawable.crewneck
            3 -> R.drawable.phonecase
            else -> R.drawable.cargo
        }
        imageView.setImageResource(resourceId)

        val textView: TextView = findViewById(R.id.nameTextView)
        textView.text = katalog[index]
    }
}