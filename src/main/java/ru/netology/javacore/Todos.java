package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private Set<String> taskList;

    public Todos() {
        taskList = new TreeSet<>();
    }

    public void addTask(String task) {
        if (task == null || task.equals("")) return;
        Gson gson = new GsonBuilder().create();
        String taskString = gson.toJson(task);

    }

    public void removeTask(String task) {
        //...
    }

    public String getAllTasks() {
        //...
    }

}
