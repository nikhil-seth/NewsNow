package com.example.myapplication;

public class Category {
    public boolean isCategory() {
        return isCategory;
    }

    public void setCategory(boolean category) {
        isCategory = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean isCategory;
    private String name;

    public Category(boolean isCategory, String name) {
        this.isCategory = isCategory;
        this.name = name;
    }

}

