package biz.global77.com.lms.service;

import biz.global77.com.lms.model.Image;
import biz.global77.com.lms.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImageService {

    private ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Transactional
    public void saveImage(Image image) {
        imageRepository.save(image);
    }

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
