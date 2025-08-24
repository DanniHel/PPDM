/*
Adivina Número.
Escribe un programa que genere un número aleatorio entre 1 y 30,
luego pida al usuario que adivine el número.
Proporciona pistas indicando si el número a adivinar es mayor o menor
que el número ingresado por el usuario.
Continúa solicitando intentos hasta que el usuario adivine correctamente el número.
Tienes 5 intentos, si se acaba debe imprimir game over.
De lo contrario mostrar un mensaje de felicitación por ganar el juego.
*/

// importar la libreria de aleatorio
import kotlin.random.Random

// funcion que nos dice si es mayor o menor
fun comprobar(num: Int, computadora: Int): String {
    if (num > computadora) return "El numero es Menor que $num"
    else if(num < computadora) return "El numero es mayor que $num"
}
fun main(){
    // se genera un número aleatorio
    val aleatorio: Int = Random.nextInt(1,30)

    println("Generé un Numero entre 1 y 30, también puede se 1 o 30")
    println("Adivina cual es ese número: ")

    var intentos: Int = 5 // variable para controlar el número de intentos
    while (intentos > 0){
        println("Tienes $intentos Intentos")
        println("Escoge un Numero:")
        val num: Int = readLine()!!.toInt()
        if (num == aleatorio) intentos = -2 // si se encuentra el número se sale del bucle
        else {
            println(comprobar(num, aleatorio)) // comprovamos con la funcion
            intentos--
        }

    }
    // mensages finales
    if (intentos == -2){
        println("Felicitaciones por ganar el juego")
    }else{
        println("Se agotaron tus intentos")
        println("El numero secreo era: $aleatorio")
    }
}