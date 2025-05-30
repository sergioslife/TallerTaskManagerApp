package com.task.hub.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.task.hub.presentation.ui.screen.add.Member
import kotlinx.parcelize.RawValue
import java.time.LocalDate

// Declara la entidad 'Task' que representa una tabla en la base de datos Room.
@Entity(tableName = "Task")
data class Task(
    // Clave primaria (PrimaryKey) que se autogenera para cada nueva fila (tarea).
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // Título de la tarea. Por defecto es una cadena vacía.
    val title: String = "",

    // Descripción de la tarea. También por defecto es una cadena vacía.
    val description: String = "",

    // Fecha límite (dueDate) de la tarea, usando LocalDate. Por defecto es la fecha actual.
    val dueDate: LocalDate = LocalDate.now(),

    // Tiempo estimado (en minutos u otra unidad) para completar la tarea.
    val estimateTime: Int = 0,

    // Prioridad de la tarea (por ejemplo: "Alta", "Media", "Baja").
    val priority: String = "",

    // Lista de miembros asignados a esta tarea.
    // La anotación @RawValue permite que Room ignore cómo serializar esta lista (se asume convertidor externo).
    val members: @RawValue List<Member> = emptyList()
)
