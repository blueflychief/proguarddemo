package com.infinite.proguarddemoapp.entity;

public class MusicEntity {
    public String url;
    public String title;
    public int during;

    public MusicEntity(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MusicEntity{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", during=" + during +
                '}';
    }
}
