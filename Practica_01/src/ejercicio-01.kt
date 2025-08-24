/*

Evaluación Empleados.

En una determinada empresa, sus empleados son evaluados cada seis meses.
Los puntos que pueden obtener en la evaluación comienzan en 0 y pueden
ir aumentando hasta llegar a 10, traduciéndose en mejores beneficios.
Al final del problema se muestra una tabla con los niveles correspondientes
a cada puntuación. La cantidad de dinero conseguida en cada nivel  se
calcula multiplicando el salario mensual por la  división de la puntuación
del nivel divida entre 10. Escribir un programa que lea la puntuación del
usuario y su salario mensual e imprima su nivel de rendimiento, así como
la cantidad de dinero que recibirá el usuario.
Ejemplo:
Salario 10,000; Puntuación 8. Dinero = 10,000 * (8/10)= 8000.
Resultado: Nivel de Rendimiento Aceptable, Cantidad de Dinero Recibido $8000.

*/

// Función que obtiene la cantidad de dinero segun los puntos obtenidos
fun CalcularRendimiento(puntos: Int, salario: Double): Double{
    return salario * (puntos/10.0)
}

// funcion para clasificar los puntos en categorias
fun GetNivel(puntos: Int): String {
    return when(puntos){
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Error: Puntos fuera de rango (0 .. 10)"
    }
}

// funcion principal
fun main(){
    println("______Calcular Rendimiento______")
    print("Ingresa El salario: ")

    // obtenemos el salario y convertimos a Decimal
    val salario: Double = readLine()!!.toDouble()
    print("Ingresa los Puntos: ")

    // obtenemos los puntos y convertimos a entero
    val puntos: Int = readLine()!!.toInt()

    // imprimimos los resultados llamando a las funciones correspondientes
    println("=============================")
    println("Para el salario: $salario y Puntos obtenidos: $puntos")
    println("\n Nivel de Rendimiento: ${GetNivel(puntos)}")
    println("Cantidad de Dinero Recibido: ${CalcularRendimiento(puntos, salario)}")
}