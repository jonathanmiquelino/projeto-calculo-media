package com.example.calculomedia

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.aq.*
import kotlinx.android.synthetic.main.teste_software.btnCalcular
import kotlinx.android.synthetic.main.teste_software.btnLimpar

class InterfaceAQ : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aq)
        btnCalcular.setOnClickListener {
            if (validarCampos()) {
                var media = calcularResultado()
                mostrarResultado(media)
            }
        }
        btnLimpar.setOnClickListener {
            limparCampos()
        }
    }

    fun calcularResultado(): Double{
        var p1 = txtProva1.text.toString().toDouble();
        var p2 = txtProva2.text.toString().toDouble();
        var ado1 = txtAdo1.text.toString().toDouble();
        var ado2 = txtAdo2.text.toString().toDouble();
        return (p1*0.4)+(p2*0.4)+(ado1*0.1)+(ado2*0.1)
    }

    fun limparCampos(){
        txtProva1.text.clear()
        txtProva2.text.clear()
        txtAdo1.text.clear()
        txtAdo2.text.clear()
    }

    fun mostrarResultado(media: Double){
        val intent= Intent(this, Resultado::class.java)
        intent.putExtra("resultado", media)
        startActivity(intent)
    }

    fun validarCampos(): Boolean{
        var msg = "";
        var campoNPreechido = false;
        if(txtProva1.text.isEmpty()){
            msg = "PROVA1 "
            campoNPreechido = true
        }
        if(txtProva2.text.isEmpty()){
            msg +="PROVA2 "
            campoNPreechido = true
        }
        if(txtAdo1.text.isEmpty()){
            msg += "ADO1 "
            campoNPreechido = true
        }
        if(txtAdo2.text.isEmpty()){
            msg += "ADO2 "
            campoNPreechido = true
        }
        if(campoNPreechido){
            Toast.makeText(this, "Os campos a seguir não estão preenchidos \n$msg", Toast.LENGTH_SHORT).show()
            return false;
        }
        return true;
    }
}

