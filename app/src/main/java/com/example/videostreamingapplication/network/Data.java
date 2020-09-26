package com.example.videostreamingapplication.network;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {

    private String description;
    private String subtitle;
    private String thumb;
    private String title;
    private List<String> sources;

    public Data(String description, String subtitle, String thumb, String title, List<String> sources) {
        this.description = description;
        this.subtitle = subtitle;
        this.thumb = thumb;
        this.title = title;
        this.sources = sources;
    }

    public Data() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }
}
