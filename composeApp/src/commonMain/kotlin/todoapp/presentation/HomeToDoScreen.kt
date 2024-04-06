package todoapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.md_theme_light_primary
import todoapp.presentation.components.ToDoCategory
import todoapp.presentation.components.gridItems
import todoapp.presentation.model.ToDo

@Composable
fun ToDoHomeScreen(
    state: ToDoViewModel.ToDoViewState,
    newToDo: ToDo?,
    onEvent: (ToDoEvent) -> Unit,
) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(
            modifier = Modifier.size(80.dp),
            onClick = {
                onEvent(ToDoEvent.OnAddNewToDoClicked) },
            containerColor = md_theme_light_primary,
            shape = CircleShape,
            content = {
                Icon(
                    modifier = Modifier.size(40.dp),
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add todo",
                    tint = Color.White
                )
            })
    }) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = "Lists",
                    color = Color.Black,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Start,
                    lineHeight = 22.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp, start = 36.dp, end = 36.dp)
                )
            }
            gridItems(
                horizontalArrangement = Arrangement.spacedBy(
                    24.dp,
                    alignment = Alignment.CenterHorizontally
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 24.dp),
                data = state.categories,
                columnCount = 2,
                itemContent = { itemData ->
                    ToDoCategory(itemData)
                }
            ) {
                onEvent(ToDoEvent.SelectToDoCategory(it))
                // onDashboardTypePressed(uiState.listOfDashboardTypes[position].type)
            }
        }
    }
    AddToDoSheet(
        newToDo = newToDo,
        onEvent = { event ->
            onEvent(event)
        },
        state = state
    )


    ToDoCategoryDetailsSheet(selectedCategory = state.selectedCategory, onEvent = {
        onEvent(it)
    }, state = state)
}

