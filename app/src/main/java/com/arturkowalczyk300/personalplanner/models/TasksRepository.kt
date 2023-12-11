package com.arturkowalczyk300.personalplanner.models

import android.content.Context
import androidx.lifecycle.LiveData

class TasksRepository {
    private lateinit var database: TasksDatabase
    private var dao: TasksDAO? = null

    fun initDatabase(ctx: Context) {
        database = TasksDatabase.getInstance(ctx)
        dao = database.tasksDao()
    }

    fun getAllTasks(): LiveData<List<TaskEntity>>? = dao?.getAll()
}