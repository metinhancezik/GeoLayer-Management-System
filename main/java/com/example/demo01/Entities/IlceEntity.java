package com.example.demo01.Entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "ilcepolygon") // Tablo adını belirtin
public class IlceEntity {
    @Id
    @Column(name = "gid") // "gid" sütunu için eşleşme yapın
    private Long id; // gid

    @Column(name = "adi_numara") // "adi_numara" sütunu için eşleşme yapın
    private String ilceAdi; // adi_numara

    @Column(name = "ilceref") // "ilceref" sütunu için eşleşme yapın
    private BigDecimal ilceNo; // ilceref
    // Add constructor(s), additional methods, etc. if needed
}

