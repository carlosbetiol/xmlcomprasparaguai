package com.romapy.xmlcomprasparaguai.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.persistence.*;

@Entity
//@Table(name = "r_view_url_product_images")
public class Image {

    @EmbeddedId
    @JsonIgnore
    private imageId id;

    @JsonProperty("codigo")
    @Column(name = "product_code", insertable = false, updatable = false)
    private String codigoPega;

    @JsonProperty("link")
    @Column(name = "url_web")
    private String productUrl;

    @JsonProperty("link_imagem")
    @Column(name = "image_url")
    private String imageUrl;

    @JsonProperty("preco")
    private String price;

    @JsonProperty("disponibilidade")
    @Column(name = "availability")
    private String availability;

    @JsonProperty("marca")
    private String brand;

    @JsonProperty("title")
    @Column(name = "product_name")
    private String name;

    @Column(name = "description_short")
    private String description;

    public imageId getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getAvailability() {
        return availability;
    }

    public String getBrand() {
        return brand;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public String getDescription() {
        return description;
    }

}
