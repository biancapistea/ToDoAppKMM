package todoapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import todoapp.presentation.model.ToDo
import todoapp.presentation.model.ToDoCategory

@Composable
fun ToDoCategoryDetailsSheet(
    modifier: Modifier = Modifier,
    state: ToDoViewModel.ToDoViewState,
    onEvent: (ToDoEvent) -> Unit,
    selectedCategory: ToDoCategory?
) {

}