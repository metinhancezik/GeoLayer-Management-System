package com.example.demo01.Services;
import com.example.demo01.Entities.IlceEntity;
import com.example.demo01.Entities.IlceEntity;
import com.example.demo01.Interfaces.IlceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class IlceService {

    private final IlceInterface ilceRepository;

    @Autowired
    public IlceService(IlceInterface ilceRepository) {
        this.ilceRepository = ilceRepository;
    }

    public  List<IlceEntity> IlceGetir() {
        return ilceRepository.findAll();
    }
}