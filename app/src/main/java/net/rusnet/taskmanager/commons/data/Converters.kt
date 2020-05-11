package net.rusnet.taskmanager.commons.data

import androidx.room.TypeConverter
import net.rusnet.taskmanager.commons.domain.model.TaskType
import java.util.*

object Converters {

    @JvmStatic
    @TypeConverter
    fun fromTaskType(taskType: TaskType) = taskType.name

    @JvmStatic
    @TypeConverter
    fun toTaskType(taskTypeAsString: String): TaskType {
        return requireNotNull(TaskType.values().find { it.name == taskTypeAsString })
    }

    @JvmStatic
    @TypeConverter
    fun fromDate(date: Date?) = date?.time

    @JvmStatic
    @TypeConverter
    fun toDate(dateAsLong: Long?) = dateAsLong?.let { Date(dateAsLong) }

}