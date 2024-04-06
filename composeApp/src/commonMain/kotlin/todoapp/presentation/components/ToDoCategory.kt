package todoapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import todoapp.presentation.model.ToDoCategory

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ToDoCategory(toDoCategory: ToDoCategory) {
    Surface(
        modifier = Modifier.shadow(
            elevation = 20.dp,
            spotColor = Color.DarkGray
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                modifier = Modifier.size(50.dp).align(Alignment.Start),
                painter = painterResource(toDoCategory.image),
                contentDescription = "home"
            )
            Text(
                text = toDoCategory.title,
                color = Color.Black,
                fontSize = 20.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .width(122.dp)
                    .padding(top = 24.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "${toDoCategory.noOfTasks} tasks",
                color = Color.DarkGray,
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .width(122.dp)
                    .fillMaxWidth()
            )
        }
    }
}