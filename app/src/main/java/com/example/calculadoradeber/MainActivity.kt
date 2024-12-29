package com.example.calculadoradeber

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {//llave de inicio de la clase
    //declarar variables globales
    private lateinit var numero1: EditText
    private lateinit var numero2: EditText
    private lateinit var sumar: Button
    private lateinit var restar: Button
    private lateinit var multiplicar: Button
    private lateinit var dividir: Button
    private lateinit var resultado: TextView
    private lateinit var operacion: CalcularOperacion




    override fun onCreate(savedInstanceState: Bundle?) {//llave de inicio del metodo onCreate
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //inicializar variables
        numero1 = findViewById(R.id.etnum1)
        numero2 = findViewById(R.id.etnum2)
        sumar = findViewById(R.id.btnSumar)
        restar = findViewById(R.id.btnRestar)
        multiplicar = findViewById(R.id.btnMultiplicar)
        dividir = findViewById(R.id.btnDividir)
        resultado = findViewById(R.id.tvResultado)
        operacion = CalcularOperacion()

        //onClick para sumar
        sumar.setOnClickListener {
            sumar()
        }
        //onClick para restar
        restar.setOnClickListener {
            restar()
        }
        //onClick para multiplicar
        multiplicar.setOnClickListener {
            multiplicar()
        }
        //onClick para dividir
        dividir.setOnClickListener {
            dividir()
        }

    }//llave de cierre del metodo onCreate

    //función suma
    private fun sumar() {
        if (validar()) {
            //llamar a la función sumar de la clase CalcularOperacion
            resultado.setText("El resultado de la suma es = ${operacion.sumar()}")
        }else{
            Toast.makeText(this, "¡DATOS INCOMPLETOS!", Toast.LENGTH_SHORT).show()
        }


    }

    //función resta
    private fun restar() {
        if (validar()) {
            //llamar a la función sumar de la clase CalcularOperacion
            resultado.setText("El resultado de la resta es = ${operacion.restar()}")
        }else{
            Toast.makeText(this, "¡DATOS INCOMPLETOS!", Toast.LENGTH_SHORT).show()
        }


    }

    //función multiplicación
    private fun multiplicar() {
        if (validar()) {
            //llamar a la función sumar de la clase CalcularOperacion
            resultado.setText("El resultado de la multiplicación es = ${operacion.multiplicar()}")
        }else{
            Toast.makeText(this, "¡DATOS INCOMPLETOS!", Toast.LENGTH_SHORT).show()
        }


    }

    //función división
    private fun dividir() {
        if (validar()) {
            //llamar a la función sumar de la clase CalcularOperacion
            resultado.setText("El resultado de la división es = ${operacion.dividir()}")
        }else{
            Toast.makeText(this, "¡DATOS INCOMPLETOS!", Toast.LENGTH_SHORT).show()
        }


    }

    //validar entrada de datos
    private fun validar(): Boolean {
        val num1 : String = numero1.text.toString()
        val num2 : String = numero2.text.toString()
        //isNullOrEmpty devuelve true si esta vacío o nulo

        //                                 num2=" " true=false
        // num1=3   falsw= true            num2=4  false=true
        if(!num1.isNullOrEmpty() && !num2.isNullOrEmpty()){
            operacion.num1 = num1.toInt()
            operacion.num2 = num2.toInt()
            return true
        }
        return false
    }




}//llave de cierre de la clase