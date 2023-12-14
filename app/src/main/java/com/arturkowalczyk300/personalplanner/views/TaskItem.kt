package com.arturkowalczyk300.personalplanner.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TaskItem(isFinished: Boolean, priority: Int, name: String, description: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(Modifier.weight(1f)) {
            Checkbox(checked = isFinished, onCheckedChange = {})
        }
        Column(Modifier.weight(1f)) {
            Text("$priority")
        }
        Column(Modifier.weight(2f)) {
            Text("$name")
        }
        Column(Modifier.weight(2f)) {
            Text("$description", color = Color(61, 59, 59, 255))
        }
    }
}

@Preview
@Composable
fun TaskItemPreview() {
    TaskItem(true, 1, "Clean room", "my room")
}