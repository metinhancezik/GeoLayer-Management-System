package com.example.demo01.Interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo01.Entities.IlceEntity;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IlceInterface extends JpaRepository<IlceEntity, Long> {

    List<IlceEntity> findByIlceAdi(String ilceAdi);

    // MahalleEntity verilerini ilçe no'ya göre getir
    List<IlceEntity> findByIlceNo(BigDecimal ilceNo);

    // Örnek: MahalleEntity kayıtlarını adi_numara (ilçeAdi) ve ilceref (ilceNo) değerine göre getir
    List<IlceEntity> findByIlceAdiAndIlceNo(String ilceAdi, BigDecimal  ilceNo);

    // Özelleştirilmiş SQL sorgusu kullanma
    //@Query("SELECT m FROM MahalleEntity m WHERE m.ilceNo > :ilceNo")
    // List<MahalleEntity> findByIlceNoGreaterThan(long ilceNo);

}