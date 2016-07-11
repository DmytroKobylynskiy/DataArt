package com.hack.repo;

import com.hack.entities.Picture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Wollf on 05.07.2016.
 */
public interface PictureRepository extends CrudRepository<Picture, Long> {

    Picture findOne(Long id);
    List<Picture> findByUserId(Long id);


}
