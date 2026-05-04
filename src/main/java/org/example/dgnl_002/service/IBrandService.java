package org.example.dgnl_002.service;

import org.example.dgnl_002.dto.BrandDTO;
import org.example.dgnl_002.model.Brand;

import java.util.List;

public interface IBrandService {
    void addBrand(BrandDTO brandDTO);
    List<Brand> findAll();
}
