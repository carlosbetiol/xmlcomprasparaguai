package com.romapy.xmlcomprasparaguai.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "rss")

public class ImagesXmlRssWrapper {

    @JacksonXmlProperty(isAttribute = true,localName = "version")
    private String version;

    @JsonProperty(value = "channel")
    private ImagesXmlWrapper rss;

    public ImagesXmlRssWrapper() {
    }

    public ImagesXmlRssWrapper(ImagesXmlWrapper rss) {
        this.rss = rss;
        this.version = "2.0";
    }

    public ImagesXmlWrapper getRss() {
        return rss;
    }

    public void setRss(ImagesXmlWrapper rss) {
        this.rss = rss;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
