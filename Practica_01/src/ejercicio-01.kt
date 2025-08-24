fun CalcularRendimiento(puntos: Int, salario: Double): Double{
    return salario * (puntos/10.0)
}

fun GetNivel(puntos: Int): String {
    return when(puntos){
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Error: Puntos fuera de rango (0 .. 10)"
    }
}

fun main(){
    println("______Calcular Rendimiento______")
    print("Ingresa El salario: ")
    val salario: Double = readLine()!!.toDouble()
    print("Ingresa los Puntos: ")
    val puntos: Int = readLine()!!.toInt()
    println("=============================")
    println("Para el salario: $salario y Puntos obtenidos: $puntos")
    println("\n Nivel de Rendimiento: ${GetNivel(puntos)}")
    println("Cantidad de Dinero Recibido: ${CalcularRendimiento(puntos, salario)}")
}