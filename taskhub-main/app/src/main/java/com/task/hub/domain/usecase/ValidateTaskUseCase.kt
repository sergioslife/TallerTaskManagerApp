package com.task.hub.domain.usecase

// Importa la clase TaskValidationState, que representa el estado de validación de una tarea
import com.task.hub.domain.model.TaskValidationState

// Importa la clase Member, que representa un miembro asignado a la tarea
import com.task.hub.presentation.ui.screen.add.Member

// Importa LocalDate para manejar fechas de vencimiento
import java.time.LocalDate

/**
 * Clase que valida los datos de una tarea antes de insertarla en el sistema.
 * Se encarga de comprobar que el título, descripción, fecha de vencimiento y miembros son correctos.
 */
class ValidateTaskUseCase {

    /**
     * Ejecuta el proceso de validación con los datos de la tarea.
     * Recibe los parámetros de la tarea y devuelve un objeto TaskValidationState con los resultados.
     */
    fun execute(
        title: String,
        description: String,
        dueDate: LocalDate,
        selectedMembers: MutableList<Member>
    ): TaskValidationState {

        // Valida cada campo individualmente
        val titleResult = validateTitle(title)
        val descriptionResult = validateDescription(description)
        val dueDateResult = validateDueDate(dueDate)
        val membersResult = validateMembers(selectedMembers)

        // Comprueba si todas las validaciones fueron exitosas
        val isSuccessful = listOf(
            titleResult,
            descriptionResult,
            dueDateResult,
            membersResult
        ).all { it }

        // Retorna el estado de validación con los resultados obtenidos
        return TaskValidationState(
            isValidTitle = titleResult,
            isValidDescription = descriptionResult,
            isValidDueDate = dueDateResult,
            isMemberSelected = membersResult,
            isSuccessful = isSuccessful
        )
    }

    /**
     * Verifica que el título no esté vacío.
     * Retorna `true` si el título tiene contenido, `false` en caso contrario.
     */
    private fun validateTitle(title: String): Boolean {
        return title.isNotEmpty()
    }

    /**
     * Verifica que la descripción no esté vacía o que tenga al menos 5 caracteres.
     * Retorna `true` si la descripción es válida, `false` si no cumple con los requisitos.
     */
    private fun validateDescription(description: String): Boolean {
        return description.isNotEmpty() || description.length > 5
    }

    /**
     * Comprueba que la fecha de vencimiento no sea anterior a la fecha actual.
     * Retorna `true` si la fecha es válida, `false` si es una fecha pasada.
     */
    private fun validateDueDate(dueDate: LocalDate): Boolean {
        return !dueDate.isBefore(LocalDate.now())
    }

    /**
     * Verifica que al menos un miembro haya sido seleccionado para la tarea.
     * Retorna `true` si hay miembros asignados, `false` en caso contrario.
     */
    private fun validateMembers(members: MutableList<Member>): Boolean {
        return members.isNotEmpty()
    }
}
