/*
Descripción:
Sistema de gestión de biblioteca con materiales,
usuarios y operaciones de préstamo y devolución.

Autor: Danny Quispe Cjuiro
Fecha de creación: 31/08/2025
Fecha última modificación: 31/08/2025
*/

// clase abstracta base
abstract class Material(val titulo: String, val autor: String, val anioPublicacion: Int) {
    abstract fun mostrarDetalles()

    fun detallesGenerales() {
        println("Título: $titulo")
        println("Autor: $autor")
        println("Año: $anioPublicacion")
    }
}

// clase Libro
class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val genero: String,
    val numeroPaginas: Int
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        detallesGenerales()
        println("Género: $genero")
        println("Número de páginas: $numeroPaginas")
    }
}

// clase Revista
class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        detallesGenerales()
        println("ISSN: $issn")
        println("Volumen: $volumen")
        println("Número: $numero")
        println("Editorial: $editorial")
    }
}

// clase Usuario
data class Usuario(val nombre: String, val apellido: String, val edad: Int)

// interfaz
interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material)
    fun devolverMaterial(usuario: Usuario, material: Material)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesPrestadosPorUsuario(usuario: Usuario)
}

// implementación
class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuarios = mutableListOf<Usuario>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    override fun registrarUsuario(usuario: Usuario) {
        if (usuario !in usuarios) {
            usuarios.add(usuario)
            prestamos[usuario] = mutableListOf()
        }
    }

    override fun prestarMaterial(usuario: Usuario, material: Material) {
        if (material !in materialesDisponibles) {
            println("Material no disponible: ${material.titulo}")
            return
        }
        if (usuario !in usuarios) {
            println("Usuario no registrado: ${usuario.nombre}")
            return
        }

        materialesDisponibles.remove(material)
        prestamos[usuario]?.add(material)
        println("Material prestado: ${material.titulo} a ${usuario.nombre}")
    }

    override fun devolverMaterial(usuario: Usuario, material: Material) {
        if (prestamos[usuario]?.contains(material) == true) {
            prestamos[usuario]?.remove(material)
            materialesDisponibles.add(material)
            println("Material devuelto: ${material.titulo}")
        } else {
            println("Este material no está prestado a este usuario.")
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("\nMateriales disponibles:")
        if (materialesDisponibles.isEmpty()) {
            println("No hay materiales disponibles.")
        } else {
            materialesDisponibles.forEach {
                println("-------------")
                it.mostrarDetalles()
            }
        }
    }

    override fun mostrarMaterialesPrestadosPorUsuario(usuario: Usuario) {
        println("\nMateriales prestados por ${usuario.nombre}:")
        val lista = prestamos[usuario]
        if (lista.isNullOrEmpty()) {
            println("No tiene materiales prestados.")
        } else {
            lista.forEach {
                println("-------------")
                it.mostrarDetalles()
            }
        }
    }
}

fun main() {
    val biblioteca = Biblioteca()

    // Usuarios
    val ana = Usuario("Ana", "García", 28)
    val juan = Usuario("Juan", "Pérez", 35)

    biblioteca.registrarUsuario(ana)
    biblioteca.registrarUsuario(juan)

    // Materiales
    val libro1 = Libro("la luna llena", "tesla", 1949, "romance", 328)
    val revista1 = Revista("Ciencia para todos", "editariales", 2022, "112-334", 5, 12, "Edicion especial")

    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(revista1)

    // Mostrar disponibles
    biblioteca.mostrarMaterialesDisponibles()

    // Préstamos
    biblioteca.prestarMaterial(ana, libro1)
    biblioteca.prestarMaterial(juan, revista1)

    // Mostrar después del préstamo
    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesPrestadosPorUsuario(ana)

    // Devolución
    biblioteca.devolverMaterial(ana, libro1)
    biblioteca.mostrarMaterialesDisponibles()
}
