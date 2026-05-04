package org.example.dgnl_002.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dgnl_002.dto.BrandDTO;
import org.example.dgnl_002.model.Brand;
import org.example.dgnl_002.repository.IBrandRepository;
import org.example.dgnl_002.service.IBrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements IBrandService {
    private final IBrandRepository brandRepository;
    @Override
    public void addBrand(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setName(brandDTO.getName());
        brand.setDescription(brandDTO.getDescription());
        brandRepository.save(brand);
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }
}
