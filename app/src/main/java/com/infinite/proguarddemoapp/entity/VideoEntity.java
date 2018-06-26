package com.infinite.proguarddemoapp.entity;

public class VideoEntity extends BaseEntity {
    public String url;
    public String title;
    public int during;

    public VideoEntity(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "VideoEntity{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", during=" + during +
                '}';
    }
}
