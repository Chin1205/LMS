package biz.global77.controller;

import biz.global77.model.Image;
import biz.global77.repository.ImageRepository;
import biz.global77.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ImageController {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/lms2";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "nTp2019feb27*";

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

//    @GetMapping("/image/{id}")
//    public byte[] getImage(@PathVariable Long id) {
//        byte[] imageData = null;
//        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
//            String sql = "SELECT data FROM image WHERE id = ?";
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setLong(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                imageData = resultSet.getBytes("data");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return imageData;
//    }
    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        // Retrieve image from database based on id
        byte[] image = imageService.getImage(id).getData();

        // Set the content type and return the image in the response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
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
