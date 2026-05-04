package org.example.dgnl_002.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dgnl_002.dto.BrandDTO;
import org.example.dgnl_002.dto.DeviceDTO;
import org.example.dgnl_002.model.Brand;
import org.example.dgnl_002.model.Device;
import org.example.dgnl_002.repository.IDeviceRepository;
import org.example.dgnl_002.service.IBrandService;
import org.example.dgnl_002.service.IDeviceService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class DeviceController {
    private final IDeviceService deviceService;
    private final IBrandService brandService;
    private final Cloudinary cloudinary;

    @GetMapping
    public String device(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size

    ){
        Page<Device> devicePage = deviceService.findAll(page, size);
        model.addAttribute("devices",devicePage.getContent());
        model.addAttribute("page",page);
        model.addAttribute("size",size);
        model.addAttribute("totalPage",devicePage.getTotalPages());
        model.addAttribute("currentPage",devicePage.getNumber());
        return "device";
    }

    @GetMapping("/add/device")
    public String addDevice(
            Model model
    ){
        model.addAttribute("device",new DeviceDTO());
        List<Brand> listBrand =brandService.findAll();
        model.addAttribute("brands",listBrand);
        return "addDevice";
    }
    @PostMapping("/add/devices")
    public String addDevice(
            @RequestParam("file") MultipartFile file,
            @Valid
            @ModelAttribute(name = "device")DeviceDTO deviceDTO,
            BindingResult result
            ){
        if(result.hasErrors()){
            return "addDevice";
        }
        try {
            if (!file.isEmpty()) {
                String publicId = UUID.randomUUID().toString();
                Map uploadResult = cloudinary.uploader().upload(
                        file.getBytes(),
                        ObjectUtils.asMap(
                                "public_id", publicId
                        )
                );
                String url = uploadResult.get("secure_url").toString();
                deviceDTO.setProductImage(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Device device = new Device();
        device.setDeviceName(deviceDTO.getDeviceName());
        device.setModelCode(deviceDTO.getModelCode());
        device.setPrice(deviceDTO.getPrice());
        device.setManufactureDate(deviceDTO.getManufactureDate());
        device.setProductImage(deviceDTO.getProductImage());
        device.setAvailable(true);
        device.setBrand(deviceDTO.getBrand());
        deviceService.save(device);
        return "redirect:/";
    }


}
