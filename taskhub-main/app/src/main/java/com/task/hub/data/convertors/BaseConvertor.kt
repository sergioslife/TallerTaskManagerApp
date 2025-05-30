package com.task.hub.data.convertors

import androidx.room.TypeConverter

// Clase abstracta genérica que define cómo convertir tipos personalizados para Room
abstract class BaseConverter<T> {

    /**
     * Convierte un valor del tipo [T] a String.
     * Room usa este método para guardar el valor en la base de datos.
     * La implementación por defecto usa toString(), pero se puede sobreescribir.
     *
     * @param value El objeto del tipo [T] a convertir.
     * @return Una representación en String del objeto, o null si el objeto es null.
     */
    @TypeConverter
    open fun toString(value: T?): String? = value?.toString()

    /**
     * Convierte una cadena [String] a un objeto del tipo [T].
     * Si el valor es nulo o vacío, devuelve null.
     * Si no, llama al método abstracto objectFromString para hacer la conversión específica.
     * Room usa este método para reconstruir el objeto desde la base de datos.
     *
     * @param value El String a convertir.
     * @return Un objeto del tipo [T] o null si el String es nulo o vacío.
     */
    @TypeConverter
    open fun fromString(value: String?): T? =
        if (value.isNullOrEmpty()) null else objectFromString(value)

    /**
     * Método abstracto que deben implementar las subclases para definir
     * cómo convertir un String a un objeto del tipo [T].
     * Cada subclase proporcionará su propia lógica de conversión.
     *
     * @param value El String a convertir.
     * @return El objeto del tipo [T], o null si la conversión falla.
     */
    abstract fun objectFromString(value: String): T?
}
