package com.arturkowalczyk300.personalplanner.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arturkowalczyk300.personalplanner.models.TaskEntity

@Composable
fun TasksList(data: List<TaskEntity>) {
    LazyColumn {
        items(data) {
            TaskItem(
                isFinished = it.isFinished,
                priority = it.priority,
                name = it.name,
                description = it.description ?: ""
            )
        }
    }
}

@Composable
@Preview
fun TasksListPreview() {
    TasksList(
        listOf(
            TaskEntity(0, "Clean the room", "room 1", 2, false, 0, 0, 0),
            TaskEntity(1, "Do the washing", "", 1, true, 0, 0, 0),
        )
    )
}