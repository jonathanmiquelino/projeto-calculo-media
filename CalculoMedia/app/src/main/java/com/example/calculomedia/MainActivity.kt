package com.example.calculomedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnADMTI.setOnClickListener{
                val intent= Intent(this, InterfaceADMTI::class.java)
                startActivity(intent)
        }

        btnAQ.setOnClickListener{
            val intent= Intent(this, InterfaceAQ::class.java)
            startActivity(intent)
        }

        btnDSM.setOnClickListener{
            Toast.makeText(
                this,
                "Em desenvolvimento",
                Toast.LENGTH_SHORT
            ).show()
        }

        btnGP.setOnClickListener{
            val intent= Intent(this, InterfaceGP::class.java)
            startActivity(intent)
        }

        btnPi4.setOnClickListener{
            val intent= Intent(this, InterfacePI4::class.java)
            startActivity(intent)
        }

        btnTS.setOnClickListener{
            val intent= Intent(this, InterfaceTS::class.java)
            startActivity(intent)
        }
    }
}