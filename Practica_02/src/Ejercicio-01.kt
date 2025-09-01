/*

Descripción:
Clase CuentaBancaria con saldo, límite de retiro,
y métodos para gestionar retiros validados.

Autor: Danny Quispe Cjuiro
Fecha de creación: 31/08/2025
Fecha última modificación: 31/08/2025

*/

//clase cuenta bancaria, inicializado con un constructor primario
class CuentaBancaria(val nombre: String, var saldoInicial: Double) {

    // validamos que el saldo no sea números negativos
    init{
        require(saldoInicial > 0.0) { "El saldo debe ser mayor a 0.0" }
    }

    // variable saldo que se irá modificando
    var saldo:Double
        get() = saldoInicial
        set(value) {
            require(value > 0.0) { "El saldo NO debe ser negativo" }
            saldoInicial = value
        }

    // el límite de retiro será el 50% del saldo total
    var limiteRetiro:Double = 0.5 * saldo
        /* get() = 0.5 * saldo ---> cada vez que se accede a limiteRetiro,
           se calcula automáticamente el 50% del saldo actual.
           El valor de limiteRetiro cambia porque depende de saldo, que sí cambia. ----*/

    // Función para retirar
    fun retirar(monto:Double): Unit {

        //validar valores negativos
        if (monto<0) println("\nError, el monto ingresado debe ser mayor a 0.0")
        else{
            // no permite retirar más que el límite de retiro
            if(monto>limiteRetiro) {
                println("\nError, el el monto exedio el límite de retiro: $limiteRetiro")
            }else{
                saldo -= monto
                limiteRetiro -= monto
                println("\n¡¡Se retiró exitosamente S/. $monto !!")
            }
        }


    }

    // función para imprimir todos los atributos de la clase
    fun imprimir() {
        println("nombre de la cuenta: $nombre")
        println("saldo actual: $saldo")
        println("Retiro disponible: $limiteRetiro")
    }
}

fun main(){
    // instancia de la clase CuentaBancaria
    val ana = CuentaBancaria("Ana", 1200.00)
    ana.imprimir()

    ana.retirar(200.0)
    ana.imprimir()

    ana.retirar(400.0)
    ana.imprimir()

    ana.retirar(2.0)
    ana.imprimir()
}
