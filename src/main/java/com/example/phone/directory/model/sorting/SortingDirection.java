package com.example.phone.directory.model.sorting;

public enum SortingDirection {
    ASC("ASC"),
    DESC("DESC");

    public final String label;

    private SortingDirection(String label)
    {
        this.label = label;
    }
}
