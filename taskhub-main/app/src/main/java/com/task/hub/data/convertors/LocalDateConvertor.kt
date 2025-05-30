package com.task.hub.data.convertors

import java.time.LocalDate

// Esta clase se encarga de convertir un objeto LocalDate a String y viceversa,
// para permitir a Room almacenar fechas en formato de texto en la base de datos.
class LocalDateConverter : BaseConverter<LocalDate>() {

    /**
     * Convierte un String en un objeto LocalDate.
     *
     * @param value El String a convertir. Se espera un formato compatible con LocalDate.parse (ISO_LOCAL_DATE, por ejemplo "2025-05-29").
     * @return Un objeto LocalDate correspondiente al String. Si el formato no es válido o ocurre un error, devuelve null.
     *
     * Esta función se invoca desde el método fromString() de la clase BaseConverter.
     * Si Room almacena una fecha en formato texto, este método reconstruye el objeto LocalDate.
     */
    override fun objectFromString(value: String): LocalDate? = try {
        // Intenta convertir el String a LocalDate utilizando el formato estándar ISO.
        LocalDate.parse(value)
    } catch (e: Exception) {
        // Si ocurre un error (por ejemplo, formato inválido), devuelve null para indicar fallo de conversión.
        null
    }
}
