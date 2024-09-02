package com.kafka.producer_comsumer_demo;

import java.util.StringJoiner;

public class MoreSimpleModel {

    private String title;
    private String description;

    public MoreSimpleModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public MoreSimpleModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return title + " " + description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
