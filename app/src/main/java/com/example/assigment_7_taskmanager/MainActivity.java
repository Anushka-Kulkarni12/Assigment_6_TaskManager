package com.example.assigment_7_taskmanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Task> taskList;
    private LinearLayout taskContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskContainer = findViewById(R.id.taskContainer);
        taskList = new ArrayList<>();

        Button addButton = findViewById(R.id.btnAdd);
        addButton.setOnClickListener(v -> {
            Task newTask = new Task("New Task", "Task Description");
            taskList.add(newTask);
            addTaskView(newTask);
            Toast.makeText(MainActivity.this, "Task added", Toast.LENGTH_SHORT).show();
        });
    }

    private void addTaskView(Task task) {
        View taskView = LayoutInflater.from(this).inflate(R.layout.task_activity, taskContainer, false);

        TextView title = taskView.findViewById(R.id.taskTitle);
        TextView description = taskView.findViewById(R.id.taskDescription);
        Button deleteButton = taskView.findViewById(R.id.btnDelete);

        title.setText(task.getTitle());
        description.setText(task.getDescription());

        deleteButton.setOnClickListener(v -> {
            taskList.remove(task);
            taskContainer.removeView(taskView);
            Toast.makeText(MainActivity.this, "Task deleted", Toast.LENGTH_SHORT).show();
        });

        taskContainer.addView(taskView);
    }
}
