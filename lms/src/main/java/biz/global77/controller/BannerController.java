package biz.global77.controller;
import biz.global77.model.Banner;
import biz.global77.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@Controller
public class BannerController {

    @Autowired
    private BannerRepository bannerRepository;

    @GetMapping("/banners")
    public String viewAllBanners(Model model) {
        // get all banners from the database
        Iterable<Banner> banners = bannerRepository.findAll();
        // add the banners to the model
        model.addAttribute("banners", banners);
        return "banners";
    }

    @GetMapping("/banners/{id}")
    public String viewBanner(@PathVariable Long id, Model model) {
        // get the banner with the specified ID from the database
        Banner banner = bannerRepository.findById(id).orElseGet(Banner::new);
        // add the banner to the model
        model.addAttribute("banner", banner);
        return "banner";
    }


    @GetMapping("/banners/{id}/edit")
    public String editBannerForm(@PathVariable Long id, Model model) {
        // retrieve the banner with the specified ID from the database
        Optional<Banner> optionalBanner = bannerRepository.findById(id);
        if (optionalBanner.isPresent()) {
            // add the banner to the model
            model.addAttribute("banner", optionalBanner.get());
            return "edit_banner";
        } else {
            // banner not found
            return "error";
        }
    }

    @PostMapping("/banners/{id}/edit")
    public String editBanner(@PathVariable Long id, @ModelAttribute Banner banner) {
        // update the banner with the specified ID in the database
        banner.setId(id);
        bannerRepository.save(banner);
        return "redirect:/banners";
    }

    @PostMapping("/banners/add")
    public String addBanner(@RequestParam("file") MultipartFile file,
                            @RequestParam("title") String title,
                            @RequestParam("description") String description) throws IOException {
        // create a new banner object
        Banner banner = new Banner();
        banner.setTitle(title);
        banner.setDescription(description);
        // set the image data for the banner
        banner.setImage(file.getBytes());
        // save the banner to the database
        bannerRepository.save(banner);
        return "redirect:/banners";
    }
    @DeleteMapping("/banners/{id}")
    public String deleteBanner(@PathVariable Long id) {
        // delete the banner with the specified ID from the database
        bannerRepository.deleteById(id);
        return "redirect:/banners";
    }

}



