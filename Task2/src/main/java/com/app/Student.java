package com.app;


public class Student {

    private int id;
    private String name;
    private String batch;
    private String email;

    // Constructor
    public Student(int id, String name, String batch, String email) {
        this.id = id;
        this.name = name;
        this.batch = batch;
        this.email = email;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getBatch() { return batch; }
    public String getEmail() { return email; }
}
