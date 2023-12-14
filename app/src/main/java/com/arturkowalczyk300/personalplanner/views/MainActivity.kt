package com.arturkowalczyk300.personalplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.arturkowalczyk300.personalplanner.models.TaskEntity
import com.arturkowalczyk300.personalplanner.viewmodels.TasksViewModel
import com.arturkowalczyk300.personalplanner.views.TasksList
import com.arturkowalczyk300.personalplanner.views.theme.MyApplicationTheme

data class MyTaskState(val tasksList: List<TaskEntity>)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<TasksViewModel>()
            viewModel.initDatabase(LocalContext.current)

            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("user")
                    TasksFragment(viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Composable
fun TasksFragment(viewModel: TasksViewModel) {
    Column {
        Row(modifier = Modifier.weight(5f)) {
            val tasks: State<List<TaskEntity>?> = viewModel.tasks.observeAsState()
            tasks.value?.let {
            TasksList(tasks)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = { viewModel.actionAddRandomTask() }) {
                Text("Add random")
            }
            Button(onClick = { viewModel.actionDeleteAllTasks() }) {
                Text("Delete all")
            }
            Button(onClick = { viewModel.actionRefresh() }) {
                Text("Refresh")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    MyApplicationTheme {
        Greeting("user")
        //TasksFragment()
    }
}