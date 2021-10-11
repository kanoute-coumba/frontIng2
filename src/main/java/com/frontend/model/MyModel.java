package com.frontend.model;

public class MyModel implements Comparable{

    public Integer id;
    public String name;

    public MyModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public MyModel() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

