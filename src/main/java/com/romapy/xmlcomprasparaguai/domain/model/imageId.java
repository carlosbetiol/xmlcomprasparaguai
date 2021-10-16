package com.romapy.xmlcomprasparaguai.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class imageId implements Serializable {

//    @Column(name = "id_image")
    private Integer idImage;

//    @JsonProperty("codigo")
    @Column(name = "product_code")
    private String productIdPega;

    public imageId() {
    }

    public imageId(Integer idImage, String productIdPega) {
        this.idImage = idImage;
        this.productIdPega = productIdPega;
    }

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }

    public String getProductIdPega() {
        return productIdPega;
    }

    public void setProductIdPega(String productIdPega) {
        this.productIdPega = productIdPega;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        imageId imageId = (imageId) o;

        if (!idImage.equals(imageId.idImage)) return false;
        return productIdPega.equals(imageId.productIdPega);
    }

    @Override
    public int hashCode() {
        int result = idImage.hashCode();
        result = 31 * result + productIdPega.hashCode();
        return result;
    }

}
