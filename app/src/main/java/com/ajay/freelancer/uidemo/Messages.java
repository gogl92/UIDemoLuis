package com.ajay.freelancer.uidemo;

public class Messages {
    public String heading;
    public String content;
    public String time;
    public int photoId;

    Messages(String heading, String content, String time,int photoId) {
        this.heading = heading;
        this.content = content;
        this.time = time;
        this.photoId = photoId;
    }
}