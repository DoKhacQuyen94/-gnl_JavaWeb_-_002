package org.example.dgnl_002.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Optional;

@Entity
@Table(name = "devices")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceName;
    private String modelCode;
    private Double price;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate manufactureDate;
    private String productImage;
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

}
