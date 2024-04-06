package todoapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.md_theme_light_primary
import kotlinx.datetime.LocalDateTime
import todoapp.presentation.components.SimpleBottomSheet
import todoapp.presentation.model.ToDo
import todoapp.utils.now

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddToDoSheet(
    modifier: Modifier = Modifier,
    state: ToDoViewModel.ToDoViewState,
    newToDo: ToDo?,
    onEvent: (ToDoEvent) -> Unit
) {
    SimpleBottomSheet(
        visible = state.isAddToDoSheetOpen,
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(60.dp))
                ToDoTextField(
                    value = newToDo?.description ?: "",
                    onValueChanged = {},
                    placeholder = "What are you planning?"
                )
                Date()
                Button(
                    modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                    onClick = {
                        onEvent(ToDoEvent.SaveToDo)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = md_theme_light_primary)
                ) {
                    Text(
                        text = "Create",
                        modifier = Modifier.padding(10.dp),
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }
            Text(
                text = "New task",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp).align(Alignment.TopCenter)
            )
            IconButton(
                modifier = Modifier.align(Alignment.TopEnd),
                onClick = {
                    onEvent(ToDoEvent.DismissToDo)
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "Close"
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Date() {
    val date = LocalDateTime.now()
    val statePicker = rememberDatePickerState(
        yearRange = date.year..date.year + 1,
        initialDisplayMode = DisplayMode.Input,
    )
    val dateFormatter = remember { DatePickerFormatter() }

    DatePicker(
        state = statePicker,
        title = {},
        headline = {
            DatePickerDefaults.DatePickerHeadline(
                state = statePicker,
                dateFormatter = dateFormatter,
                modifier = Modifier.size(20.dp)
            )
        }
    )
}


@Composable
private fun ToDoTextField(
    value: String,
    placeholder: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        TextField(
            value = value,
            placeholder = {
                Text(text = placeholder)
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedIndicatorColor = md_theme_light_primary,
                unfocusedIndicatorColor = md_theme_light_primary
            ),
            onValueChange = onValueChanged,
            modifier = Modifier.fillMaxWidth().height(160.dp)
        )
    }
}