/*
2.
Piedra, Papel, Tijera.
Escriba un programa que realice el juego de piedra, papel o tijera.
La computadora debe elegir de manera aleatoria la opción a elegir.
Después debe preguntar al usuario que opción quiere.
Imprimir si ganó, perdió o empató.

*/

// importamos la librería necesario para numeros Aleatorios
import kotlin.random.Random

// funcion para comparar respuestas del usuario y la computadora
fun getResultado(opcion: Int): String {
    if (opcion > 0 && opcion <= 3){
        val aleatorio: Int = Random.nextInt(1, 3)

        //comparamos resultados
        if(opcion == aleatorio){
            return " yo elegí $aleatorio \n\n ¡¡Empate!!"
        } else if ( // agrupamos todas las opciones ganadoras
            opcion == 1 && aleatorio == 3 ||
            opcion == 2 && aleatorio == 1 ||
            opcion == 3 && aleatorio == 2
            ){
            return " yo elegí $aleatorio \n\n ¡¡Ganaste!!"
        }else{
            return " yo elegí $aleatorio \n\n ¡¡Perdiste!!"
        }
    } else{
        return "La opción ingresada es Incorrecto"
    }
}

// funcion principal
fun main(){
    println("_____ Piedra, Papel, Tijera _____")
    println("\nEstoy eligiendo una opción ... ")
    println("\nTu tambien elige:")
    println("1 es Piedra")
    println("2 es Papel")
    println("3 es Tijera")
    print("\nEscribe tu opcion aquí: ")

    // si se digitan otros valores no numéricos ( toInt )
    try {
        val opcion = readLine()!!.toInt()
        println(getResultado(opcion))
    } catch(ex: NumberFormatException) {
        println("La opcion ingresada no es un número")
    }

}