package com.jantonioc.application2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var error: Int = 0
    val requestCode_intent: Int = 3
    private lateinit var btnTess: Button
    private lateinit var txtTexto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTess = findViewById(R.id.button)
        txtTexto = findViewById(R.id.textView)

        btnTess.setOnClickListener {
            //intento de llamar a la Actividad de la Aplicación1
            val intent = Intent()
            intent.action = "com.jantonioc.application1"
            intent.addCategory("android.intent.category.DEFAULT")
            try {
                startActivityForResult(intent, requestCode_intent)
            } catch (e: Exception) {
                txtTexto.append("\n" + e.message + "\n")
                Toast.makeText(this, "¡Error de permiso no declarado!", Toast.LENGTH_SHORT).show()
                error = 1
            }

        }
    }

}