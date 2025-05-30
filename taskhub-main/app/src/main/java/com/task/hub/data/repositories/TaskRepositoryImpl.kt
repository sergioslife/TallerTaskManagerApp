package com.task.hub.data.repositories

import com.task.hub.data.local.Task
import com.task.hub.data.local.TaskDao
import com.task.hub.domain.repositories.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.time.LocalDate
import javax.inject.Inject

// Clase que implementa la interfaz TaskRepository para manejar operaciones sobre tareas (Task).
class TaskRepositoryImpl @Inject constructor(private val taskDao: TaskDao): TaskRepository {

    // Inserta una tarea en la base de datos usando Room y cambiando el contexto a IO (operaciones de disco).
    override suspend fun insertTask(task: Task) {
        withContext(Dispatchers.IO) {  // Cambia a hilo de entrada/salida para no bloquear el hilo principal.
            taskDao.insertTask(task)   // Llama al método insert del DAO.
        }
    }

    // Obtiene una lista de tareas (en forma de Flow) filtradas por fecha específica.
    override suspend fun getTasksByDate(selectedDate: LocalDate): Flow<List<Task>> {
        return taskDao.getTasksByDate(selectedDate)  // Retorna un Flow para observar cambios en tiempo real.
    }

    // Obtiene una tarea específica por su ID, también en un contexto de IO.
    override suspend fun getTaskById(taskId: Int): Task = withContext(Dispatchers.IO) {
        taskDao.getTaskById(taskId)  // Llama al método del DAO que recupera una tarea específica.
    }
}
