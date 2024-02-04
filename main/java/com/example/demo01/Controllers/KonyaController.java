package com.example.demo01.Controllers;

//import com.example.demo01.Entities.MahalleEntity;
import com.example.demo01.Entities.IlceEntity;
import com.example.demo01.Entities.MahalleEntity;
import com.example.demo01.Services.IlceService;
import com.example.demo01.Services.MahalleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class KonyaController {

    private final MahalleService mahalleService;
    private final IlceService ilceService;

    public KonyaController(IlceService ilceService, MahalleService mahalleService) {
        this.ilceService = ilceService;
        this.mahalleService = mahalleService;
    }

    @GetMapping("/Konya")
    public String showMap(Model model) {
        List<IlceEntity> ilceler = ilceService.IlceGetir();
        model.addAttribute("ilceler", ilceler);
        return "konyaMap.html";
    }

    @GetMapping("/mahalleler")
    @ResponseBody
    public List<MahalleEntity> getMahalleler() {
        return mahalleService.MahalleGetir();
    }

    @GetMapping("/ilceler")
    @ResponseBody
    public List<IlceEntity> getIlceler() {
        return ilceService.IlceGetir();
    }
}
