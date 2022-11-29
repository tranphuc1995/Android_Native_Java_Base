package com.example.galaxyonejava.presentation.model;

public class TabItem {
    public String getTitle() {
        return title;
    }

    public Boolean getActive() {
        return isActive;
    }

    private final String title;
    private final Boolean isActive;

    public TabItem(String title, Boolean isActive) {
        this.title = title;
        this.isActive = isActive;
    }


}
