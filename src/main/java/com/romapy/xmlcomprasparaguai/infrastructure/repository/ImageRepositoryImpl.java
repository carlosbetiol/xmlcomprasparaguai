package com.romapy.xmlcomprasparaguai.infrastructure.repository;

import com.romapy.xmlcomprasparaguai.domain.model.Image;
import com.romapy.xmlcomprasparaguai.domain.repository.ImageRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class ImageRepositoryImpl implements ImageRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Image> listar() {
        TypedQuery<Image> typedQuery = manager.createQuery("select i "+
                "from Image i", Image.class);
        return typedQuery.getResultList();
    }


}
