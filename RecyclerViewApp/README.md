# Práctica Guiada: RecyclerView con Edición y Long Click


## Resumen

Esta práctica muestra cómo usar **RecyclerView** con elementos editables mediante **long click**. Se implementa un **menú de opciones** (Editar / Eliminar) y un **diálogo personalizado** para modificar datos sin cambiar de pantalla. También se incluye un **botón para agregar nuevos usuarios** de manera dinámica.


## Objetivos

- Detectar **long click** en un elemento.  
- Mostrar menú con opciones: **Editar** o **Eliminar**.  
- Abrir un diálogo para editar usuario (Nombre, Edad, Correo).  
- Actualizar la lista de usuarios usando notificaciones de cambio.  


## Implementación

- Long click en cada item del RecyclerView abre un **menú de opciones**.  
- **Editar:** abre un diálogo con los datos actuales del usuario, permitiendo modificarlos y actualizar la lista.  
- **Eliminar:** borra el usuario de la lista y actualiza la vista.  
- **Agregar:** botón flotante para añadir nuevos usuarios.  


## Prueba de la app

1. Hacer **long click** en un usuario.  
2. Seleccionar **Editar**, modificar los datos y guardar.  
3. Verificar que la lista muestre los cambios.  
4. Hacer **long click** → **Eliminar** para borrar un usuario.


## Preguntas de reflexión


**1. Diferencia entre notifyItemRemoved(), notifyItemInserted() y notifyItemChanged():**  

- `notifyItemRemoved(posición)`: elimina un elemento y actualiza la lista.  
- `notifyItemInserted(posición)`: agrega un nuevo elemento mostrando animación.  
- `notifyItemChanged(posición)`: actualiza un elemento existente sin afectar los demás.


**2. ¿Por qué validar bindingAdapterPosition != RecyclerView.NO_POSITION?:**  
Evita errores al asegurarse de que el item aún existe en la lista antes de realizar acciones como editar o eliminar.


**3. Ventajas de usar un diálogo frente a abrir otra pantalla:**  

- Mantiene el **contexto del usuario** en la pantalla principal.  
- Permite **interacción rápida y ligera**.  
- Simplifica la **lógica de navegación** y actualización de la lista.



