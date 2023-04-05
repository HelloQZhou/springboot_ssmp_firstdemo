package com.Qzhou.pojo;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;

    public Book(Integer id, String type, String name, String description) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
    }

    public Book(String type, String name, String description) {
        this.type = type;
        this.name = name;
        this.description = description;
    }

    public Book() {
    }
}
