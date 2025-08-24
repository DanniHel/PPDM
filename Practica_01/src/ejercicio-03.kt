
// funciones de operaciones matemáticas basicas
fun suma(num1: Double, num2: Double): Double = num1 + num2
fun resta(num1: Double, num2: Double): Double = num1 - num2
fun multiplicacion(num1: Double, num2: Double): Double = num1 * num2
fun division(num1: Double, num2: Double): Double = num1 / num2

// Funcion que imprimi el menú
fun menu(): Unit{
    println("==== Menú ====")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicación")
    println("4. División")
    println("5. Salir")
}

// funcion principal
fun main(){
    var llave: Int = -1 // inicializamos la llave para acceder a las opciones
    //bucle para realizar las operacion una y otra vez
    do {
        println("")
        println("")
        menu() // Imprimimos el menú
        println("")
        print("Digite una opción: ")

        //controlamos el ingreso de datos
        try {
            llave = readLine()!!.toInt()
        }catch (e:NumberFormatException){ // error si no se puede convertir a entero
            println("Error: opcion incorrecta ...")
        }

        // Segun la opcion se realizará las operaciones matemáticas
        when (llave) {
            1 -> {
                println("Para realizar la suma, digite dos números")
                print("numero 1: ")
                val num1 = readLine()!!.toDouble()
                print("numero 2: ")
                val num2 = readLine()!!.toDouble()
                print("\nLa suma es: ${suma(num1, num2)}")
            }
            2 -> {
                println("Para realizar la resta, digite dos números")
                print("numero 1: ")
                val num1 = readLine()!!.toDouble()
                print("numero 2: ")
                val num2 = readLine()!!.toDouble()
                print("\nLa resta es: ${resta(num1, num2)}")
            }
            3 -> {
                println("para realizar la multiplicación, digite dos números")
                print("numero 1: ")
                val num1 = readLine()!!.toDouble()
                print("numero 2: ")
                val num2 = readLine()!!.toDouble()
                print("\nLa multiplicación es: ${multiplicacion(num1, num2)}")
            }
            4 -> {
                println("Para realizar la división, digite dos números")
                print("numero 1: ")
                val num1 = readLine()!!.toDouble()
                print("numero 2: ")
                val num2 = readLine()!!.toDouble()
                print("\nLa division es: ${division(num1, num2)}")
            }
            5 -> println("Saliendo ...")
            else -> println("La opcion ingrasada está fuera de rango")

        }
    }while (llave != 5) // Condicion de salida del bucle


}
