package com.campelo.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {

    private lateinit var txtGasolina: TextView
    private lateinit var txtAlcool: TextView
    private lateinit var txtResultado: TextView
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        txtGasolina = findViewById(R.id.txtGasolina)
        txtAlcool = findViewById(R.id.txtAlcool)
        txtResultado = findViewById(R.id.txtResultado)
        btnVoltar = findViewById(R.id.btnVoltar)

        val bundle = intent.extras

        if(bundle != null){
            val gasolina = bundle.getDouble("gasolina")
            val alcool = bundle.getDouble("alcool")
            val resultado = alcool / gasolina

            txtGasolina.text = "Preço da Gasolina: ${gasolina}"
            txtAlcool.text = "Preço do Álcool: ${alcool}"

            txtResultado.text = if(resultado > 0.7){
                "Gasolina"
            }else{
                "Álcool"
            }
        }

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}