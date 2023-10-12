package dev.sam.contentcalendar.DTOs;

import dev.sam.contentcalendar.Model.Status;
import dev.sam.contentcalendar.Model.Type;

public class ContentDTO {
    private String title;
    private String desc;
    private Status status;
    private Type contentType;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getContentType() {
        return contentType;
    }

    public void setContentType(Type contentType) {
        this.contentType = contentType;
    }
}
