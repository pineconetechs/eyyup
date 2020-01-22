package com.architecture.Service.impl;

import com.architecture.Service.PictureService;
import com.architecture.entitiy.PictureEntity;
import com.architecture.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    PictureRepository pictureRepository;

    @Override
    public PictureEntity findPicture(Integer pictureId) {
        return pictureRepository.findByPictureId(pictureId);
    }
}
