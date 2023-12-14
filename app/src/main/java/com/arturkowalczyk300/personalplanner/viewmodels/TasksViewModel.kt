package com.arturkowalczyk300.personalplanner.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arturkowalczyk300.personalplanner.models.TaskEntity
import com.arturkowalczyk300.personalplanner.models.TasksRepository
import kotlin.random.Random

class TasksViewModel : ViewModel() {
    private val repository = TasksRepository()
    private var _tasks = MutableLiveData<List<TaskEntity>>()
    val tasks: LiveData<List<TaskEntity>> = _tasks

    fun initDatabase(ctx: Context) {
        repository.initDatabase(ctx)
        observeData()
    }

    fun actionAddRandomTask() {
        val name = "${Random.nextInt(0, 100)}"
        val desc = "${Random.nextInt(100, 200)}"
        val priority = Random.nextInt(1, 5)
        val task = TaskEntity(
            0, name, desc, priority,
            false, 0, 0, 0
        )

        repository.addTasks(task)
    }

    fun actionDeleteAllTasks() {

    }

    fun actionRefresh() {

    }

    private fun observeData()
    {
        repository.getAllTasks()?.observeForever {
            _tasks.value = it
        }
    }
}