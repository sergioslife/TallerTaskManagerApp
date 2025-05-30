package com.task.hub.data.di

import android.content.Context
import androidx.room.Room
import com.task.hub.data.local.TaskDao
import com.task.hub.data.local.TaskDatabase
import com.task.hub.data.repositories.TaskRepositoryImpl
import com.task.hub.domain.usecase.ValidateTaskUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Declara un módulo de Dagger-Hilt que proveerá las dependencias relacionadas con Room y casos de uso.
@Module
@InstallIn(SingletonComponent::class) // Indica que estas dependencias viven en el componente singleton (vida de aplicación).
object RoomModule {

    /**
     * Provee una instancia singleton de TaskRepositoryImpl.
     * @param dao La interfaz DAO para interactuar con la base de datos.
     * @return Una implementación del repositorio que usará el DAO.
     * Esto inyecta TaskRepositoryImpl donde se requiera.
     */
    @Singleton
    @Provides
    fun getRepository(dao: TaskDao): TaskRepositoryImpl {
        return TaskRepositoryImpl(dao)
    }

    /**
     * Provee una instancia singleton de TaskDao.
     * @param database La instancia de TaskDatabase creada previamente.
     * @return La interfaz DAO para realizar operaciones CRUD en la base de datos.
     * Esto permite que Room gestione el acceso a datos.
     */
    @Singleton
    @Provides
    fun getDao(database: TaskDatabase): TaskDao {
        return database.taskDao
    }

    /**
     * Provee una instancia singleton de TaskDatabase.
     * @param context El contexto de aplicación necesario para construir la base de datos.
     * @return Una base de datos Room configurada con el nombre "task_database".
     * Esto configura Room para crear y manejar la base de datos.
     */
    @Provides
    @Singleton
    fun provideTaskDatabase(
        @ApplicationContext context: Context, // Inyecta el contexto de aplicación usando Hilt.
    ) = Room.databaseBuilder(
        context,
        TaskDatabase::class.java, // La clase de la base de datos (Room).
        "task_database" // El nombre físico del archivo de la base de datos.
    ).build()

    /**
     * Provee una instancia singleton del caso de uso ValidateTaskUseCase.
     * @return Un objeto de caso de uso para validar tareas.
     * Este caso de uso encapsula la lógica de negocio para validar una tarea antes de guardarla.
     */
    @Singleton
    @Provides
    fun getValidateTaskUseCase(): ValidateTaskUseCase {
        return ValidateTaskUseCase()
    }
}
