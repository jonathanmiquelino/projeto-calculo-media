package com.example.calculomedia

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.teste_software.*

class InterfaceTS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teste_software)
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

    fun limparCampos(){
        txtAdo1.text.clear()
        txtAdo2.text.clear()
        txtP1.text.clear()
        txtP2.text.clear()
    }

    fun calcularResultado(): Double{
        var pesoADO = 0.15;
        var pesoProva=0.3;
        var ado1 = txtAdo1.text.toString().toDouble();
        var ado2 = txtAdo2.text.toString().toDouble();
        var p1 = txtP1.text.toString().toDouble();
        var p2 = txtP2.text.toString().toDouble();
        return ((ado1*pesoADO)+(ado2*pesoADO)+(p1*pesoProva)+(p2*pesoProva))
    }



    fun mostrarResultado(media: Double){
        val intent= Intent(this, Resultado::class.java)
        intent.putExtra("resultado", media)
        startActivity(intent)
    }

    fun validarCampos(): Boolean{
        var msg = "";
        var campoNPreechido = false;
        if(txtAdo1.text.isEmpty()){
            msg = "ADO1 "
            campoNPreechido = true
        }
        if(txtAdo2.text.isEmpty()){
            msg +="ADO2 "
            campoNPreechido = true
        }
        if(txtP1.text.isEmpty()){
            msg += "P1 "
            campoNPreechido = true
        }
        if(txtP2.text.isEmpty()){
            msg += "P2 "
            campoNPreechido = true
        }
        if(campoNPreechido){
            Toast.makeText(this, "Os campos a Seguir não estão preenchidos \n$msg", Toast.LENGTH_SHORT).show()
            return false;
        }
        return true;
    }
}