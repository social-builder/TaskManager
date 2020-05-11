package net.rusnet.taskmanager.commons.data

import androidx.room.*
import net.rusnet.taskmanager_old.commons.domain.model.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task_table WHERE id = :id")
    suspend fun getTask(id: Long): Task

    @Update
    suspend fun updateTask(task: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTasks(tasks: List<Task>)

    @Delete
    suspend fun deleteTask(task: Task)

    @Delete
    suspend fun deleteTasks(tasks: List<Task>)

    @Query("DELETE FROM task_table")
    suspend fun deleteAllTasks()

    @Query("SELECT * from task_table")
    suspend fun getAllTasks(): List<Task>

//    @Query(
//        "SELECT * " +
//                "FROM task_table " +
//                "WHERE (task_type = :taskType OR :taskType = 'ANY') " +
//                "AND is_completed = :isCompleted " +
//                "AND ((:useDateRange = 0) OR (end_date BETWEEN :dateRangeStart AND :dateRangeEnd))" +
//                "ORDER BY end_date IS NULL, end_date, task_id ASC"
//    )
//    fun getTasks(
//        taskType: String?,
//        isCompleted: Boolean,
//        useDateRange: Boolean,
//        dateRangeStart: Date?,
//        dateRangeEnd: Date?
//    ): Array<Task?>?

//    @Query(
//        "SELECT COUNT(*) " +
//                "FROM task_table " +
//                "WHERE (task_type = :taskType OR :taskType = 'ANY') " +
//                "AND is_completed = :isCompleted " +
//                "AND ((:useDateRange = 0) OR (end_date BETWEEN :dateRangeStart AND :dateRangeEnd))"
//    )
//    fun getTasksCount(
//        taskType: String?,
//        isCompleted: Boolean,
//        useDateRange: Boolean,
//        dateRangeStart: Date?,
//        dateRangeEnd: Date?
//    ): Int?

}