package com.task.hub

// Importa la clase Application de Android, que proporciona el contexto global de la aplicación.
import android.app.Application

// Importa la anotación HiltAndroidApp para habilitar la inyección de dependencias con Dagger Hilt.
import dagger.hilt.android.HiltAndroidApp

/**
 * Clase principal de la aplicación que extiende Application.
 * HiltAndroidApp permite que Dagger Hilt gestione la inyección de dependencias a nivel de aplicación.
 * Esto es necesario para que Hilt pueda proveer dependencias en toda la aplicación.
 */
@HiltAndroidApp
class Application: Application() {
}
