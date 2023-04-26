package com.antsrl.formazione.springbasics.uimodel;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import org.hibernate.validator.constraints.URL;

@Builder
public class Song {

    Long id;
    @NotEmpty(message = "title is mandatory")
    @Size(min = 3, max = 50, message = "title must be at least 3 and at most 50 characters long")
    String title;
    @URL
    String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
