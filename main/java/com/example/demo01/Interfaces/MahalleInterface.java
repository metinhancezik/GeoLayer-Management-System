package com.example.demo01.Interfaces;

import com.example.demo01.Entities.IlceEntity;
import com.example.demo01.Entities.MahalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface MahalleInterface extends JpaRepository<MahalleEntity, Long> {

    List<MahalleEntity> findByMahalleAdi(String mahalleAdi);


    List<MahalleEntity> findByIlceNo(BigDecimal ilceNo);


    List<MahalleEntity> findByMahalleAdiAndIlceNo(String mahalleAdi, BigDecimal ilceNo);


}