package com.l0123137.to_duh

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    private val _upcomingTasks = mutableStateListOf<String>()
    val upcomingTasks: List<String> get() = _upcomingTasks

    private val _completedTasks = mutableStateListOf<String>()
    val completedTasks: List<String> get() = _completedTasks

    // Function to add new upcoming task
    fun addUpcomingTask(task: String) {
        _upcomingTasks.add(task)
    }

    // Function to add new completed task
    fun addCompletedTask(task: String) {
        _completedTasks.add(task)
    }

    // Function to move task from upcoming to completed
    fun completeTask(task: String) {
        if (_upcomingTasks.remove(task)) {
            _completedTasks.add(task)
        }
    }

    // Function to delete upcoming task
    fun deleteUpcoming(task: String) {
        _upcomingTasks.remove(task)
    }

    // Function to delete completed task
    fun deleteCompleted(task: String) {
        _completedTasks.remove(task)
    }
}