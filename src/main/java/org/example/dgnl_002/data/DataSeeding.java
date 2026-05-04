package org.example.dgnl_002.data;

import lombok.RequiredArgsConstructor;
import org.example.dgnl_002.model.Brand;
import org.example.dgnl_002.model.Device;
import org.example.dgnl_002.repository.IBrandRepository;
import org.example.dgnl_002.repository.IDeviceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor

public class DataSeeding implements CommandLineRunner{
    private final IDeviceRepository deviceRepository;
    private final IBrandRepository brandRepository;

    @Override
    public void run(String... args) throws Exception {
        try{
            if(deviceRepository.count()>0 && brandRepository.count()>0){
                return;
            }

            Brand brand = new Brand();
            brand.setName("SamSung");
            brand.setDescription("I love SamSung");

            Brand brand2 = new Brand();
            brand2.setName("Apple");
            brand2.setDescription("I love Apple");

            Brand brand3 = new Brand();
            brand3.setName("Oppo");
            brand3.setDescription("I love Oppo");

            List<Brand> savedBrands = brandRepository.saveAll(List.of(brand, brand2, brand3));

            Device device = new Device();
            device.setDeviceName("MODEL_001");
            device.setModelCode("nà");
            device.setPrice(200000.0);
            device.setManufactureDate(LocalDate.of(2020,01,01));
            device.setProductImage("https://cdn2.fptshop.com.vn/unsafe/1920x0/filters:format(webp):quality(75)/2023_5_16_638198717619838070_dien-thoai-samsung-man-hinh-gap-thumb.jpg");
            device.setAvailable(true);
            device.setBrand(savedBrands.get(0));

            Device device2 = new Device();
            device2.setDeviceName("MODEL_002");
            device2.setModelCode("ná");
            device2.setPrice(200000.0);
            device2.setManufactureDate(LocalDate.of(2020,01,01));
            device.setProductImage("https://cdn2.fptshop.com.vn/unsafe/1920x0/filters:format(webp):quality(75)/2023_5_16_638198717619838070_dien-thoai-samsung-man-hinh-gap-thumb.jpg");
            device2.setAvailable(true);
            device2.setBrand(savedBrands.get(1));

            Device device3 = new Device();
            device3.setDeviceName("MODEL_003");
            device3.setModelCode("na");
            device3.setPrice(200000.0);
            device3.setManufactureDate(LocalDate.of(2020,01,01));
            device.setProductImage("https://cdn2.fptshop.com.vn/unsafe/1920x0/filters:format(webp):quality(75)/2023_5_16_638198717619838070_dien-thoai-samsung-man-hinh-gap-thumb.jpg");
            device3.setAvailable(true);
            device3.setBrand(savedBrands.get(2));

            Device device4 = new Device();
            device4.setDeviceName("MODEL_004");
            device4.setModelCode("nà");
            device4.setPrice(200000.0);
            device4.setManufactureDate(LocalDate.of(2020,01,01));
            device.setProductImage("https://cdn2.fptshop.com.vn/unsafe/1920x0/filters:format(webp):quality(75)/2023_5_16_638198717619838070_dien-thoai-samsung-man-hinh-gap-thumb.jpg");
            device4.setAvailable(true);
            device4.setBrand(savedBrands.get(1));

            deviceRepository.saveAll(List.of(device,device2,device3,device4));
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
