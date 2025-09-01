/*
Descripción:
Jerarquía de clases para figuras geométricas que calculan
área y perímetro (Shape, Cuadrado, Círculo, Rectángulo).

Autor: Danny Quispe Cjuiro
Fecha de creación: 31/08/2025
Fecha última modificación: 31/08/2025
*/

import kotlin.math.pow

abstract class Shape(val nombre: String){

    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double
    abstract fun imprimir() : Unit

    fun imprimirPadre(): Unit {
        println("EL area es: ${calcularArea()} m^2")
        println("Su perimetro es : ${calcularPerimetro()} m\n")
    }
}

// clase Cuadrado que hereda de figura
class Cuadrado(nombre: String,val lado: Double): Shape(nombre){
    init {
        require(lado>0.0) { "El lado de la cuadrado debe ser mayor a 0.0"}
    }
    // implementacion de las funciones
    override fun calcularArea(): Double = lado*lado
    override fun calcularPerimetro(): Double = lado*4
    override fun imprimir(): Unit {
        println("Figura: $nombre")
        println("El Lado de cuadrado es: $lado")
        imprimirPadre() // imprimimos los resultados
    }

}

//clase Rectángulo
class Rectangulo(nombre: String,val ancho: Double, val alto: Double): Shape(nombre){
    init {
        require(ancho>0.0){"El ancho debe ser mayor a 0.0"}
        require(alto > 0.0 && alto>ancho) { "El alto debe ser mayor a 0.0 y mayor a $ancho"}
    }
    // implementacion de las funciones
    override fun calcularArea(): Double = alto*ancho
    override fun calcularPerimetro(): Double = alto*2+ancho*2
    override fun imprimir(): Unit {
        println("Figura: $nombre")
        println("El ancho es: $ancho")
        println("Su alto es: $alto")
        imprimirPadre() // imprimimos los resultados
    }
}

//Clase Círculo
class Circulo(nombre: String, val radio: Double): Shape(nombre){
    init {
        require(radio>0.0){"El radio debe ser mayor a 0.0"}
    }
    // implementamos las funciones
    override fun calcularArea(): Double = Math.PI * radio.pow(2)
    override fun calcularPerimetro(): Double = 2*Math.PI * radio
    override fun imprimir(): Unit {
        println("Figura: $nombre")
        println("El radio es: $radio")
        imprimirPadre() // imprimimos los resultados
    }
}

fun main(){
    val cuadrado = Cuadrado("Cuadrado", 100.00)
    cuadrado.imprimir()

    val rectangulo = Rectangulo("Rectángulo", 25.0,42.2)
    rectangulo.imprimir()

    val circulo = Circulo("Circulo", 25.00)
    circulo.imprimir()
}