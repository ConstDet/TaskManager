package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private final int port;
    private final Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket socket = serverSocket.accept();//ждем подключения
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    Gson gson = new GsonBuilder().create();
                    JsonParser parser = new JsonParser();
                    Object obj = parser.parse(gson.toJson(in.readLine()));
                    operation(obj);
                    String deleteString = todos.getAllTasks();
                    out.println(deleteString);
                }
            }
        }
    }

    private void operation(Object obj) {
        JsonObject jsonObject = (JsonObject) obj;
        String typeOperation = jsonObject.get("type").getAsString();
        switch (typeOperation) {
            case "ADD":
                todos.addTask(jsonObject.get("task").getAsString());
                break;
            case "REMOVE":
                todos.removeTask(jsonObject.get("task").getAsString());
                break;
            default:
                throw new RuntimeException();
        }
    }
}
