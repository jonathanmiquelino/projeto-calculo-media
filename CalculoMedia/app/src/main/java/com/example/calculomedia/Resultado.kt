package com.example.calculomedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.resultado.*

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resultado)
        var media : Double = intent.getDoubleExtra("resultado", 0.0)
        txtResultado.setText("Resultado: " + "%.2f".format(intent.getDoubleExtra("resultado", 0.0)))
        if(media >= 6){
            txtStatus.setText("Aprovado")
        }else{
            txtStatus.setText("Reprovado")
        }
        btnVoltar.setOnClickListener {
            finish()
        }
    }
}