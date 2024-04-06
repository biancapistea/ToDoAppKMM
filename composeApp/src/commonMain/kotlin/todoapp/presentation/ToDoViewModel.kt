package todoapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.jetbrains.skia.skottie.Logger
import todoapp.presentation.model.CategoryType
import todoapp.presentation.model.ToDo
import todoapp.presentation.model.ToDoCategory

class ToDoViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ToDoViewState())
    val uiState: StateFlow<ToDoViewState> = _uiState.asStateFlow()

    var newToDo: ToDo? by mutableStateOf(null)
        private set

    init {
        _uiState.update {
            it.copy(
                categories = listOf(
                    ToDoCategory(
                        title = CategoryType.ALL.name,
                        noOfTasks = 23,
                        image = "ic_todo.png"
                    ),
                    ToDoCategory(
                        title = CategoryType.WORK.name,
                        noOfTasks = 8,
                        image = "ic_work.png"
                    ),
                    ToDoCategory(
                        title = CategoryType.AIRPORT.name,
                        noOfTasks = 21,
                        image = "ic_airport.png"
                    ),
                    ToDoCategory(
                        title = CategoryType.MUSIC.name,
                        noOfTasks = 3,
                        image = "ic_music.png"
                    ),
                    ToDoCategory(
                        title = CategoryType.HOME.name,
                        noOfTasks = 23,
                        image = "ic_home2.png"
                    ),
                    ToDoCategory(
                        title = CategoryType.SHOPPING.name,
                        noOfTasks = 6,
                        image = "ic_shopping.png"
                    ),
                    ToDoCategory(
                        title = CategoryType.ART.name,
                        noOfTasks = 3,
                        image = "ic_art.png"
                    ),
                    ToDoCategory(
                        title = CategoryType.STUDY.name,
                        noOfTasks = 5,
                        image = "ic_study.png"
                    )
                )
            )
        }
    }

    fun onEvent(toDoEvent: ToDoEvent) {
        when (toDoEvent) {
            is ToDoEvent.DeleteToDo -> TODO()
            is ToDoEvent.DismissToDo -> {
                _uiState.update {
                    it.copy(
                        isAddToDoSheetOpen = false,
                    )
                }
                newToDo = null
            }

            is ToDoEvent.EditToDo -> TODO()
            is ToDoEvent.OnAddNewToDoClicked -> {
                _uiState.update { it.copy(isAddToDoSheetOpen = true) }
                newToDo = ToDo(date = "", description = "", isDone = false, category = "")
            }

            is ToDoEvent.OnDescriptionToDoChanged -> TODO()
            is ToDoEvent.OnIsCheckedChanged -> TODO()
            is ToDoEvent.SaveToDo -> TODO()
            is ToDoEvent.SelectToDo -> TODO()
            is ToDoEvent.SelectToDoCategory -> {
                _uiState.update {
                    it.copy(
                        isDetailsToDoCategorySheetOpen = true,
                        isAddToDoSheetOpen = false,
                        selectedCategory = toDoEvent.toDo
                    )
                }
            }

            is ToDoEvent.OnDateToDoChanged -> TODO()
        }
    }

    data class ToDoViewState(
        val categories: List<ToDoCategory> = listOf(),
        val isAddToDoSheetOpen: Boolean = false,
        val isDetailsToDoCategorySheetOpen: Boolean = false,
        val selectedCategory: ToDoCategory? = null
    )
}
