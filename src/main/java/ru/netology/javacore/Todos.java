package ru.netology.javacore;

import java.util.*;

public class Todos {
    protected Set<String> taskTreeSet;

    public Todos() {
        taskTreeSet = new TreeSet<>();
    }

    public void addTask(String task) {
        if (taskTreeSet.size() > 6) return;
        taskTreeSet.add(task);
    }

    public void removeTask(String task) {
        taskTreeSet.remove(task);
    }

    public String getAllTasks() {
        Optional<String> optionalS = taskTreeSet.stream()
                .map(Object::toString)
                .reduce((x, y) -> x + " " + y);
        return optionalS.get();
    }

}
