package com.example.calculomedia

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.admti.*
import kotlinx.android.synthetic.main.teste_software.btnCalcular
import kotlinx.android.synthetic.main.teste_software.btnLimpar

class InterfaceADMTI : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admti)
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
        var nota1 = txtnota1.text.toString().toDouble();
        var nota2 = txtnota2.text.toString().toDouble();
        var nota3 = txtnota3.text.toString().toDouble();
        var nota4 = txtnota4.text.toString().toDouble();
        var nota5 = txtnota5.text.toString().toDouble();
        var prj = txtProjeto.text.toString().toDouble();
        return (((nota1+nota2+nota3+nota4+nota5)/5)*0.5) + (prj*0.5)
    }

    fun limparCampos(){
        txtnota1.text.clear()
        txtnota2.text.clear()
        txtnota3.text.clear()
        txtnota4.text.clear()
        txtnota5.text.clear()
        txtProjeto.text.clear()
    }

    fun mostrarResultado(media: Double){
        val intent= Intent(this, Resultado::class.java)
        intent.putExtra("resultado", media)
        startActivity(intent)
    }

    fun validarCampos(): Boolean{
        var msg = "";
        var campoNPreechido = false;
        if(txtnota1.text.isEmpty()){
            msg = "NOTA1 "
            campoNPreechido = true
        }
        if(txtnota2.text.isEmpty()){
            msg +="NOTA2 "
            campoNPreechido = true
        }
        if(txtnota3.text.isEmpty()){
            msg += "NOTA3 "
            campoNPreechido = true
        }
        if(txtnota4.text.isEmpty()){
            msg += "NOTA4 "
            campoNPreechido = true
        }
        if(txtnota5.text.isEmpty()){
            msg += "NOTA5 "
            campoNPreechido = true
        }
        if(txtProjeto.text.isEmpty()){
            msg += "Nota Projeto"
            campoNPreechido = true
        }
        if(campoNPreechido){
            Toast.makeText(this, "Os campos a seguir não estão preenchidos \n$msg", Toast.LENGTH_SHORT).show()
            return false;
        }
        return true;
    }
}