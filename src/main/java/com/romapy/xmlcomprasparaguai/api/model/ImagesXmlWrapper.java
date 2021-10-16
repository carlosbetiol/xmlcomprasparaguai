package com.romapy.xmlcomprasparaguai.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.romapy.xmlcomprasparaguai.domain.model.Image;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

public class ImagesXmlWrapper {

    @JsonProperty("item")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Image> images;

    private String title;

    private String link;

    private String description;

    public ImagesXmlWrapper(List<Image> images, String title, String url, String description) {
        this.images = images;
        this.title = title;
        this.link = url;
        this.description = description;
    }

    public ImagesXmlWrapper() {
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
