package com.example.calculadoradeber

class CalcularOperacion(var num1: Int=0, var num2: Int=0) : Operacion {

    //Interfaz

    override fun sumar(): Int {
        return num1 + num2
    }

    override fun restar(): Int {
        return num1 - num2
    }

    override fun multiplicar(): Int {
        return num1 * num2
    }

    override fun dividir(): Int {
        return num1 / num2
    }


}