import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import todoapp.presentation.ToDoHomeScreen
import todoapp.presentation.ToDoViewModel

@Composable
fun App() {
    MaterialTheme {
        Surface(Modifier.fillMaxSize()) {
            val viewModel = getViewModel(
                key = "todo-screen",
                factory = viewModelFactory {
                    ToDoViewModel()
                }
            )
            val state by viewModel.uiState.collectAsState()

            ToDoHomeScreen(
                state = state,
                newToDo = viewModel.newToDo,
                onEvent = viewModel::onEvent
            )
        }
    }
}