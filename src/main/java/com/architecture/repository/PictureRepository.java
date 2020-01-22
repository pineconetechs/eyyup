package com.architecture.repository;

import com.architecture.entitiy.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<PictureEntity,Integer> {
    PictureEntity findByPictureId(Integer pictureId);
}
