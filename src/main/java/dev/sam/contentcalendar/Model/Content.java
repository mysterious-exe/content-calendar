package dev.sam.contentcalendar.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Content{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotBlank(message="Title may not be blank")
    private String title;


    @NotBlank(message="Description may not be blank")
    private String desc;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Type contentType;


    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private String url;


    public Content(int id, String title, String desc, Status status, Type contentType, String url) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.status = status;
        this.contentType = contentType;
        this.url = url;
    }

    public Content() {
        dateCreated = LocalDateTime.now();
        dateUpdated = null;
    }


    public int getId() {
        return id;
    }


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

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}