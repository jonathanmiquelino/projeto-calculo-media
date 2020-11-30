package com.example.calculomedia

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.gp.*
import kotlinx.android.synthetic.main.teste_software.*
import kotlinx.android.synthetic.main.teste_software.btnCalcular
import kotlinx.android.synthetic.main.teste_software.btnLimpar

class InterfaceGP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gp)
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

    fun limparCampos() {
        txtProva.text.clear()
        txtTestes.text.clear()
        txtPcol.text.clear()
    }

    fun calcularResultado(): Double {
        var p = txtProva.text.toString().toDouble();
        var t = txtTestes.text.toString().toDouble();
        var pcol = txtPcol.text.toString().toDouble();
        return (p * 0.6) + (t * 0.2) + (pcol * 0.2)
    }


    fun mostrarResultado(media: Double) {
        val intent = Intent(this, Resultado::class.java)
        intent.putExtra("resultado", media)
        startActivity(intent)
    }

    fun validarCampos(): Boolean {
        var msg = "";
        var campoNPreechido = false;
        if (txtProva.text.isEmpty()) {
            msg = "-> Prova "
            campoNPreechido = true
        }
        if (txtTestes.text.isEmpty()) {
            msg += "\n-> Media de testes "
            campoNPreechido = true
        }
        if (txtPcol.text.isEmpty()) {
            msg += "\n-> Produção coletiva "
            campoNPreechido = true
        }
        if (campoNPreechido) {
            Toast.makeText(
                this,
                "Os campos a Seguir não estão preenchidos \n$msg",
                Toast.LENGTH_SHORT
            ).show()
            return false;
        }
        return true;
    }
}

