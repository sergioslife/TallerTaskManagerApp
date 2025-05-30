package com.task.hub.domain.model

// Data class que representa el estado de validación de los campos de una tarea.
data class TaskValidationState (
    // Indica si el título de la tarea es válido.
    var isValidTitle: Boolean = false,

    // Indica si la descripción de la tarea es válida.
    var isValidDescription: Boolean = false,

    // Indica si la fecha de vencimiento (dueDate) es válida.
    var isValidDueDate: Boolean = false,

    // Indica si al menos un miembro fue seleccionado para la tarea.
    var isMemberSelected: Boolean = false,

    // Indica si la validación general fue exitosa.
    var isSuccessful: Boolean = false
)
