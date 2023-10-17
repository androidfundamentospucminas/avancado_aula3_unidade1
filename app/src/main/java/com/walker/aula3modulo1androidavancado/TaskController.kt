package com.walker.aula3modulo1androidavancado

class TaskController {

    private val tasks = mutableListOf<TaskModel>()

    init {
        addTask(TaskModel("Tarefa 1", "Descricao da tarefa 1", true))
        addTask(TaskModel("Tarefa 2", "Descricao da tarefa 2", false))
        addTask(TaskModel("Tarefa 3", "Descricao da tarefa 3", true))
    }

    fun getTasks(): List<TaskModel> {
        return tasks
    }

    fun addTask(task: TaskModel) {
        task.id = tasks.size
        tasks.add(task)
    }

    fun updateTask(position: Int) {
        tasks[position].isCompleted = !tasks[position].isCompleted
    }

    fun deleteTask(position: Int) {
        tasks.remove(tasks[position])
    }

}