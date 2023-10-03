package com.kokochi.rhythmgame.model;

public class DataItem {
    private String name;
    private String resourcePath;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DataItem(String name, String imagePath, String description) {
        this.name = name;
        this.resourcePath = imagePath;
        this.description = description;
    }
}
