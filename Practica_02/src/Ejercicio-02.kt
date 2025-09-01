/*
Descripción:
Clase Producto con precio,
descuento y cálculo de precio final validado.

Autor: Danny Quispe Cjuiro
Fecha de creación: 31/08/2025
Fecha última modificación: 31/08/2025
*/

//clase producto
class Producto(val nombre: String, val precio: Double){

    init {
        require(precio > 0.0) { "El precio debe ser mayor a 0.0" }
    }

    // creamos un atributo para que sea opcional - para evitar el constructor primario
    private var descuento: Double = 0.0
        get() = field //redundante
        set(value) {
            require(value >= 0.0) { "El precio debe ser mayor a 0.0" }
            field = value
        }

    // constructor secundario para insertar el descuento
    constructor(nombre: String, precio: Double, descuento:Double) : this(nombre, precio){
        this.descuento = descuento
    }

    //función para calcular el precio final
    fun precioFinal(): Double = precio - (precio * descuento)

    // función para imprimir los datos
    fun imprimir(): Unit{
        println("\nnombre: $nombre")
        println("precio: S/. $precio")
        println("descuento: S/. ${precio*descuento}")
        println("Total a pagar S/. ${precioFinal()}")
    }
}

fun main(){
    // el descuento es en porcentaje 0.5 = 50%
    val manzana = Producto("Manzana", 100.00, 0.5)
    manzana.imprimir()

    // El descuento es opcional
    val pera = Producto("Pera", 100.00)
    pera.imprimir()

    val descuento: Double = 0.0
    val naranja = Producto("Naranja", 100.00, descuento)
    naranja.imprimir()
}