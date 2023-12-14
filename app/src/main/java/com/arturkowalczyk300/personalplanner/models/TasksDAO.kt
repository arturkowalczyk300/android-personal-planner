package com.arturkowalczyk300.personalplanner.models

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TasksDAO {
    @Query("SELECT * FROM tasks")
    fun getAll(): LiveData<List<TaskEntity>>

    @Insert
    fun add(vararg tasks: TaskEntity)

    @Update
    fun update(task: TaskEntity)

    @Delete
    fun delete(task: TaskEntity)

    @Query("DELETE FROM tasks")
    fun deleteAll()
}