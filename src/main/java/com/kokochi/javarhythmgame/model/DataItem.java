package com.kokochi.javarhythmgame.model;

public class DataItem {
    private String name;
    private String imagePath;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DataItem(String name, String imagePath, String description) {
        this.name = name;
        this.imagePath = imagePath;
        this.description = description;
    }
}
