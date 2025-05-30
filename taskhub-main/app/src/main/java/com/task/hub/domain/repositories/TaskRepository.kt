package com.task.hub.domain.repositories

// Importa la clase Task, que representa una tarea almacenada en la base de datos
import com.task.hub.data.local.Task

// Importa Flow para el manejo de datos asíncronos en tiempo real
import kotlinx.coroutines.flow.Flow

// Importa LocalDate para manejar fechas en la aplicación
import java.time.LocalDate

/**
 * Interfaz que define las operaciones para gestionar tareas en la aplicación.
 * Se utiliza una interfaz para abstraer la fuente de datos, facilitando la implementación con diferentes orígenes (Room, Firebase, etc.).
 */
interface TaskRepository {

    /**
     * Inserta una tarea en la base de datos.
     * La función es suspendida para ejecutarse en una corrutina sin bloquear el hilo principal.
     */
    suspend fun insertTask(task: Task)

    /**
     * Obtiene una lista de tareas filtradas por una fecha específica.
     * Devuelve un Flow<List<Task>> para que los datos puedan ser observados y actualizados en tiempo real.
     */
    suspend fun getTasksByDate(selectedDate: LocalDate): Flow<List<Task>>

    /**
     * Obtiene una tarea específica según su ID.
     * Devuelve un objeto Task o null si la tarea no existe.
     */
    suspend fun getTaskById(taskId: Int): Task
}
