package com.task.hub.data.convertors

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.task.hub.presentation.ui.screen.add.Member

// Clase encargada de convertir listas de objetos Member a JSON y viceversa para Room
class ListConvertor {

    /**
     * Convierte una lista de objetos [Member] en una cadena JSON.
     * Room usa este método para guardar listas de objetos complejos como un solo String en la base de datos.
     *
     * @param value La lista de objetos [Member] a convertir.
     * @return Una cadena JSON que representa la lista, por ejemplo: "[{...}, {...}]".
     */
    @TypeConverter
    fun listToJsonString(value: List<Member>?): String = Gson().toJson(value)

    /**
     * Convierte una cadena JSON en una lista de objetos [Member].
     * Room usa este método para reconstruir la lista original desde el String guardado.
     *
     * @param value La cadena JSON que representa la lista.
     * @return Una lista de objetos [Member] reconstruida desde el JSON.
     */
    @TypeConverter
    fun jsonStringToList(value: String) = Gson().fromJson(value, Array<Member>::class.java).toList()
}
