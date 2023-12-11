package com.arturkowalczyk300.personalplanner.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.arturkowalczyk300.personalplanner.models.TaskEntity
import com.arturkowalczyk300.personalplanner.models.TasksRepository

class TasksViewModel : ViewModel() {
    private val repository = TasksRepository()
    val tasks: LiveData<List<TaskEntity>>? = repository.getAllTasks()

    fun initDatabase(ctx: Context){
        repository.initDatabase(ctx)
    }

    fun actionAddRandomTask(){

    }

    fun actionDeleteAllTasks(){

    }

    fun actionRefresh(){

    }
}