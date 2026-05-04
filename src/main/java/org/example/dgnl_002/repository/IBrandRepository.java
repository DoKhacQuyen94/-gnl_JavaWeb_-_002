package org.example.dgnl_002.repository;

import org.example.dgnl_002.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<Brand, Long> {
    Brand findById(long id);
}
