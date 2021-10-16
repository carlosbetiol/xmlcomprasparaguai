package com.romapy.xmlcomprasparaguai.api.controller;

import com.romapy.xmlcomprasparaguai.api.model.ImagesXmlRssWrapper;
import com.romapy.xmlcomprasparaguai.api.model.ImagesXmlWrapper;
import com.romapy.xmlcomprasparaguai.domain.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/comprasparaguai")
public class ImageController {

    private final ImageRepository imageRepository;

    @Value("${owner.title}")
    private String title;

    @Value("${owner.url}")
    private String url;

    @Value("${owner.description}")
    private String description;

    public ImageController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public ImagesXmlRssWrapper listarXml() {
        return new ImagesXmlRssWrapper( new ImagesXmlWrapper(imageRepository.listar(),title,url,description));
    }
}
