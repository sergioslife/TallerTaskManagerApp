package com.task.hub

// Importa la biblioteca de JUnit para definir y ejecutar pruebas unitarias.
import org.junit.Test

// Importa la clase Assert para realizar verificaciones en las pruebas.
import org.junit.Assert.*

/**
 * Prueba unitaria local, que se ejecuta en la máquina de desarrollo (host).
 * Estas pruebas no requieren un dispositivo o emulador Android, ya que se ejecutan en la JVM.
 * Más información en la documentación oficial: http://d.android.com/tools/testing
 */
class ExampleUnitTest {

    /**
     * Prueba que verifica si la operación de suma es correcta.
     * Se espera que 2 + 2 sea igual a 4.
     */
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2) // Verifica que el resultado esperado sea igual al obtenido.
    }
}
