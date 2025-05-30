package com.task.hub.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

// DAO (Data Access Object) que define las operaciones para interactuar con la base de datos Room.
@Dao
interface TaskDao {

    // Inserta un objeto Task en la base de datos.
    // Si hay conflicto (por ejemplo, por el id), lo reemplaza con la nueva entrada.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    // Elimina un objeto Task de la base de datos.
    @Delete
    suspend fun deleteTask(task: Task)

    // Recupera una lista de tareas que tienen como fecha de entrega 'selectedDate'.
    // Devuelve un Flow para ser observado de forma reactiva (cambios automáticos).
    @Query("SELECT * FROM task WHERE dueDate =:selectedDate")
    fun getTasksByDate(selectedDate: LocalDate): Flow<List<Task>>

    // Recupera una única tarea por su id.
    // Devuelve directamente el objeto Task.
    @Query("SELECT * FROM task WHERE id =:taskId")
    fun getTaskById(taskId: Int): Task
}
