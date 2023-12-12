package com.arturkowalczyk300.personalplanner.models

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

class TasksRepository {
    private lateinit var database: TasksDatabase
    private var dao: TasksDAO? = null

    fun initDatabase(ctx: Context) {
        database = TasksDatabase.getInstance(ctx)
        dao = database.tasksDao()
    }

    fun getAllTasks(): LiveData<List<TaskEntity>>? = dao?.getAll()
    fun addTasks(vararg tasks: TaskEntity) {
        tasks.forEach { dao?.add(it) }
    }

    fun updateTask(task: TaskEntity)
    {
        dao?.update(task)
    }
    fun deleteTask(task: TaskEntity){
        dao?.delete(task)
    }
    fun deleteAllTasks(){
        dao?.deleteAll()
    }
}