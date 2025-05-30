package com.task.hub.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.task.hub.data.convertors.ListConvertor
import com.task.hub.data.convertors.LocalDateConverter

// Declara que esta clase es una base de datos Room.
// @Database contiene metadatos sobre las entidades, versión y exportación del esquema.
@Database(
    entities = [Task::class], // Lista de entidades (tablas) que maneja esta base de datos. Solo la entidad Task.
    version = 1,              // Versión inicial de la base de datos.
    exportSchema = false      // No exportar el esquema de la base de datos (útil para pruebas).
)

// Indica que se utilizarán convertidores personalizados para tipos complejos.
@TypeConverters(LocalDateConverter::class, ListConvertor::class)
abstract class TaskDatabase: RoomDatabase() {

    // Proporciona acceso al DAO (Data Access Object) que contiene las consultas y operaciones con la tabla Task.
    abstract val taskDao: TaskDao
}
