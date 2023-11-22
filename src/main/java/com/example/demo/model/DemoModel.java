package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "product"
)
public class DemoModel {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;
    @Column(
            name = "name"
    )
    private String name;

    public DemoModel(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DemoModel(String name) {
        this.id = this.id;
        this.name = name;
    }

    public DemoModel() {
    }

    @Override
    public String toString() {
        return "DemoModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
