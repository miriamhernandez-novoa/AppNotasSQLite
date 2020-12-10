package com.example.sqlite_appnotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    var myNotasDBHelper:NotasDBHelper?=null
    val DB_NAME = "notas.db"
    val DB_VERSION = 1

    var fadAdd:FloatingActionButton?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fadAdd = findViewById(R.id.fatAddNota)

        myNotasDBHelper = NotasDBHelper(this,DB_NAME,null,DB_VERSION)
        myNotasDBHelper!!.open()



        //CAMBIOS DE LA CLASE 02 DE DICIEMBRE
        val notas = myNotasDBHelper!!.getListNotas()

        for (nota in notas){
            Log.d("prueba", "${nota.titulo}")
        }

        fadAdd!!.setOnClickListener {
            val i = Intent(this, AppNotaActivity::class.java)
            startActivity(i)
        }

        /*fun onDestroy(){
            super.onDestroy()
            myNotasDBHelper!!.close()
        }*/
    }
}