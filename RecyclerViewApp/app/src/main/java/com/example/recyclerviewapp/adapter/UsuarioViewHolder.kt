package com.example.recyclerviewapp.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.R
import com.example.recyclerviewapp.Usuario

class UsuarioViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val txtNombre = view.findViewById<TextView>(R.id.txtNombre)
    private val txtEdad = view.findViewById<TextView>(R.id.txtEdad)
    private val txtCorreo = view.findViewById<TextView>(R.id.txtCorreo)
    private val btnDelete = view.findViewById<ImageButton>(R.id.btnEliminar)

    fun bind(
        user: Usuario,
        onDelete: (Int) -> Unit,
        onEdit: (Int, Usuario) -> Unit
    ) {
        txtNombre.text = user.nombre
        txtEdad.text = "Edad: ${user.edad}"
        txtCorreo.text = user.email

        // Botón eliminar
        btnDelete.setOnClickListener {
            val pos = bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                onDelete(pos)
            }
        }

        // Long click -> menú editar/eliminar
        itemView.setOnLongClickListener {
            val pos = bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                AlertDialog.Builder(itemView.context)
                    .setTitle("Acción")
                    .setItems(arrayOf("Editar", "Eliminar")) { _, which ->
                        when (which) {
                            0 -> showEditDialog(user, pos, onEdit)
                            1 -> onDelete(pos)
                        }
                    }
                    .show()
            }
            true
        }
    }

    private fun showEditDialog(user: Usuario, pos: Int, onEdit: (Int, Usuario) -> Unit) {
        val context = itemView.context
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_edit_usuario, null)

        val editNombre = dialogView.findViewById<EditText>(R.id.editNombre)
        val editEdad = dialogView.findViewById<EditText>(R.id.editEdad)
        val editCorreo = dialogView.findViewById<EditText>(R.id.editCorreo)

        // valores actuales
        editNombre.setText(user.nombre)
        editEdad.setText(user.edad.toString())
        editCorreo.setText(user.email)

        AlertDialog.Builder(context)
            .setTitle("Editar usuario")
            .setView(dialogView)
            .setPositiveButton("Guardar") { _, _ ->
                val nuevoUsuario = user.copy(
                    nombre = editNombre.text.toString(),
                    edad = editEdad.text.toString().toIntOrNull() ?: user.edad,
                    email = editCorreo.text.toString()
                )
                onEdit(pos, nuevoUsuario)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}
