package org.example.dgnl_002.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dgnl_002.model.Brand;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeviceDTO {
    private Long id;

    @Size(min = 5, max = 100, message = "Tên phải từ 5 đến 100 ký tự")
    private String deviceName;

    @NotBlank(message = "Không được để trống")
    private String modelCode;
    private Double price;
    @PastOrPresent(message = "Không đươc là ngày trong tương lai")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate manufactureDate;
    private String productImage;
    private boolean isAvailable;
    private Brand brand;
}
