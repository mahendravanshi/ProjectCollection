package com.optum.stream;

import java.util.Objects;

public class Building {
    private int id;
    private String type;

    public Building(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return id == building.id && Objects.equals(type, building.type);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
