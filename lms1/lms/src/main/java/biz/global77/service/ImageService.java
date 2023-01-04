package biz.global77.service;

import biz.global77.model.Image;
import biz.global77.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Transactional
    public void saveImage(Image image) {
        imageRepository.save(image);
    }
    @Transactional
    public Image getImage(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Transactional
    public void updateImage(Image image) {
        imageRepository.save(image);
    }

    @Transactional
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }
}
