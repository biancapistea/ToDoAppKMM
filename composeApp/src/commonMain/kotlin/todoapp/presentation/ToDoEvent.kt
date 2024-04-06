package todoapp.presentation

import todoapp.presentation.model.ToDo
import todoapp.presentation.model.ToDoCategory

sealed interface ToDoEvent {
    data object OnAddNewToDoClicked : ToDoEvent
    data object DismissToDo: ToDoEvent
    data class OnDescriptionToDoChanged(val value: String) : ToDoEvent
    data class OnDateToDoChanged(val value: String) : ToDoEvent
    data class OnIsCheckedChanged(val isChecked: Boolean) : ToDoEvent
    data object SaveToDo : ToDoEvent
    data class SelectToDoCategory(val toDo: ToDoCategory) : ToDoEvent
    data class SelectToDo(val toDo: ToDo) : ToDoEvent
    data class EditToDo(val toDo: ToDo) : ToDoEvent
    data object DeleteToDo : ToDoEvent
}