package todoapp.presentation.model

data class ToDoCategory(
    val title: String,
    val image: String,
    val tasks: List<ToDo> = listOf(),
    val noOfTasks: Int
)