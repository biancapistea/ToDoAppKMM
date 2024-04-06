package todoapp.presentation.model

data class ToDo(
    val description: String,
    val category: String,
    val isDone: Boolean,
    val date: String
)