package org.example.dgnl_002.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dgnl_002.dto.BrandDTO;
import org.example.dgnl_002.service.IBrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class BrandService {
    private final IBrandService brandService;
    @GetMapping("/add/brand")
    public String addBrand(Model model) {
        model.addAttribute("brand", new BrandDTO());
        return "addBrand";
    }

    @PostMapping("/add/brands")
    public String addBrandU(
            @Valid
            @ModelAttribute("brand") BrandDTO brandDTO,
            BindingResult result
    ) {
        if(result.hasErrors()) {
            return "addBrand";
        }
        brandService.addBrand(brandDTO);
        return "redirect:/";
    }
}
