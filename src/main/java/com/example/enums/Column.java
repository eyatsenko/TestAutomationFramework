package com.example.enums;

import lombok.Getter;

@Getter
public enum Column {
    FIRSTNAME(1, "First Name"),
    LASTNAME(2, "Last Name"),
    AGE(3, "Age"),
    EMAIL(4, "Email"),
    SALARY(5, "Salary"),
    DEPARTMENT(6, "Department"),
    ACTION(7, "Action");

    private final int index;
    private final String name;

    Column(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public static int getIndexByName(String name) {
        for (Column column : Column.values()) {
            if (column.getName().equalsIgnoreCase(name)) {
                return column.getIndex();
            }
        }
        throw new IllegalArgumentException("No column found with name: " + name);
    }
}
