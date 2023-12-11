package com.arturkowalczyk300.personalplanner.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var name: String,
    var description: String?,
    var priority: Int,
    var isFinished: Boolean = false,
    var finishDate: Long?,
    var minutesToFinish: Int?,
    var creationDate: Long
    )