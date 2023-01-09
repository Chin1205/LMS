package biz.global77.repository;

import biz.global77.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BannerRepository extends JpaRepository<Banner, Long> {

    @Query("SELECT b.image FROM Banner b WHERE b.id = :id")
    byte[] findImageById(@Param("id") Long id);
}