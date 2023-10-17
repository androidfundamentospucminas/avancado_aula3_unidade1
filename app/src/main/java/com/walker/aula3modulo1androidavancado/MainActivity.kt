package com.walker.aula3modulo1androidavancado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TaskAdapter
    private val controller = TaskController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = TaskAdapter(this, controller.getTasks())

        val tasksList = findViewById<ListView>(R.id.tasksList)

        tasksList.adapter = adapter

        tasksList.setOnItemLongClickListener { _, _, position, _ ->
            // Deletar task
            controller.deleteTask(position)
            adapter.notifyDataSetChanged()
            true
        }

        tasksList.setOnItemClickListener { _, _, position, _ ->
            // Atualizar item isCompleted (checked)
            controller.updateTask(position)
            adapter.notifyDataSetChanged()
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            // Adicionar nova task
            val newTask = TaskModel("Nova Tarefa", "Descricao da Nova Tarefa", false)
            controller.addTask(newTask)
            adapter.notifyDataSetChanged()
        }
    }
}