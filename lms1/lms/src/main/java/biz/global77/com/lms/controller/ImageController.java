package biz.global77.com.lms.controller;

import biz.global77.com.lms.model.Image;
import biz.global77.com.lms.repository.ImageRepository;
import biz.global77.com.lms.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ImageController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ImageService imageService;
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    public ImageController(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @GetMapping({"/","/home"})
    public String index() {
        return "home";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            // Return error message
        }

        try {
            // Save image to database
            Image image = new Image();
            image.setFileName(file.getOriginalFilename());
            image.setContentType(file.getContentType());
            image.setData(file.getBytes());
            imageService.saveImage(image);
        } catch (IOException e) {
            // Return error message
        }

        return "upload_successful";
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) {
        String sql = "SELECT content_type, data FROM image WHERE id = ?";
        Image image = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Image img = new Image();
            img.setContentType(rs.getString("content_type"));
            img.setData(rs.getBytes("data"));
            return img;
        });

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getContentType()))
                .body(image.getData());
    }

    @GetMapping("/banners")
    public String allBanners(Model model) {
        List<Image> images = imageRepository.findAll();
        List<Image> imagesList = images.stream()
                .collect(Collectors.toList());
        model.addAttribute("image", imagesList);
        return "banners";
    }
}
