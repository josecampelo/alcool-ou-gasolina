package com.campelo.alcoolougasolina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var tietGasolina: TextInputEditText
    private lateinit var tietAlcool: TextInputEditText
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tietGasolina = findViewById(R.id.tietGasolina)
        tietAlcool = findViewById(R.id.tietAlcool)
        btnCalcular = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            val intent = Intent(this, ResultadoActivity::class.java)
            val gasolina = tietGasolina.text.toString()
            val alcool = tietAlcool.text.toString()

            if(gasolina.isNotEmpty() && alcool.isNotEmpty()){
                intent.putExtra("gasolina", gasolina.toDouble())
                intent.putExtra("alcool", alcool.toDouble())

                startActivity(intent)
            }else{
                Toast.makeText(this, "Digite os campos de texto corretamente", Toast.LENGTH_SHORT).show()
            }
        }
    }
}