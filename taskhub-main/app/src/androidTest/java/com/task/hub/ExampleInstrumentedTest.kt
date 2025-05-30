package com.task.hub

// Importa InstrumentationRegistry, que permite acceder al contexto de la aplicación en pruebas instrumentadas.
import androidx.test.platform.app.InstrumentationRegistry

// Importa AndroidJUnit4, que es el runner de pruebas basado en JUnit para ejecutar pruebas en dispositivos Android.
import androidx.test.ext.junit.runners.AndroidJUnit4

// Importa JUnit para definir y ejecutar pruebas.
import org.junit.Test
import org.junit.runner.RunWith

// Importa Assert, que proporciona métodos para verificar resultados en pruebas unitarias.
import org.junit.Assert.*

/**
 * Prueba instrumentada que se ejecutará en un dispositivo Android.
 * Las pruebas instrumentadas permiten probar funcionalidades con el contexto real de la aplicación.
 * Más información en la documentación oficial de Android: http://d.android.com/tools/testing
 */
@RunWith(AndroidJUnit4::class) // Define el runner de pruebas para ejecutar en Android
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        // Obtiene el contexto de la aplicación bajo prueba.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        // Verifica que el nombre del paquete de la aplicación es el esperado.
        assertEquals("com.task.management", appContext.packageName)
    }
}
