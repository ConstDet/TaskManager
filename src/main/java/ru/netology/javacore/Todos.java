package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private Set<String> taskTreeSet;

    public Todos() {
        taskTreeSet = new TreeSet<>();
    }

    public void addTask(String task) {
        if (taskTreeSet.size() > 6) return;
        taskTreeSet.add(task);
    }

    public void removeTask(String task) {
        taskTreeSet.remove("task");
    }

    public String getAllTasks() {
        return taskTreeSet.stream().toString();
    }

}
