package com.example.demo01.Services;

import com.example.demo01.Entities.IlceEntity;
import com.example.demo01.Entities.MahalleEntity;
import com.example.demo01.Interfaces.IlceInterface;
import com.example.demo01.Interfaces.MahalleInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MahalleService {

    private final MahalleInterface mahalleRepository;

    @Autowired
    public MahalleService(MahalleInterface mahalleRepository) {
        this.mahalleRepository = mahalleRepository;
    }

    public List<MahalleEntity> MahalleGetir() {
        return mahalleRepository.findAll();
    }
}