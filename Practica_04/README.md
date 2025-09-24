# Práctica 4: Comunicación entre Actividades



### Autor: Danny Quispe Cjuiro  

Fecha de creación: 22/09/2025  

Última modificación: 23/09/2025  



---



## Objetivo general



Practicar la **comunicación entre actividades en Android** utilizando `Intent`, objetos `Serializable`, y el manejo de respuestas con `registerForActivityResult`. Además, se aplican técnicas para conservar datos al rotar la pantalla (`onSaveInstanceState`).



---



## Contenido de la práctica



La práctica se divide en **dos ejercicios**, cada uno representando un caso de uso distinto:



---



## Ejercicio 1: Editor de perfil con confirmación



### Descripción



Aplicación que permite al usuario llenar un perfil con los siguientes campos:



- Nombre

- Edad

- Ciudad

- Correo electrónico



### Actividades



- **FormularioActivity**  

&nbsp; Muestra los campos del formulario y un botón **“Continuar”**.



- **ResumenActivity**  

&nbsp; Muestra un resumen de los datos ingresados y permite:

&nbsp; - **Confirmar**: Regresa a la pantalla principal y muestra un `Toast` de éxito.

&nbsp; - **Volver a editar**: Retorna al formulario con los datos previos.





---



## Ejercicio 2: Editor de nota rápida



### Descripción



Aplicación que permite al usuario escribir una nota en un campo multilineal y decidir si desea compartirla o editarla nuevamente.



### Actividades



- **EditorActivity**  

&nbsp; Muestra un `EditText` multilinea para la nota y un botón **“Compartir”**.



- **OpcionesActivity**  

&nbsp; Muestra la nota y permite:

&nbsp; - **Compartir por correo**: Muestra un `Toast` de confirmación.

&nbsp; - **Editar de nuevo**: Vuelve a la actividad anterior conservando el texto.



---



## Tecnologías usadas



- Kotlin

- Android Studio

- ConstraintLayout

- Android SDK 31+



---



## Aprendizajes clave



- Enviar y recibir datos entre actividades.

- Uso de objetos serializables para pasar múltiples datos.

- Registro de resultados con `ActivityResultLauncher`.

- Manejo del ciclo de vida con `onSaveInstanceState`.

- Diseño de interfaces usando ConstraintLayout y guidelines.



---



## ✅ Estado del proyecto



✔️ Completado y funcional.



