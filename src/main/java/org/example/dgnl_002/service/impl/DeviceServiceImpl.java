package org.example.dgnl_002.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dgnl_002.model.Device;
import org.example.dgnl_002.repository.IDeviceRepository;
import org.example.dgnl_002.service.IDeviceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements IDeviceService {
    private final IDeviceRepository deviceRepository;

    @Override
    public Page<Device> findAll(int page, int size) {
        Pageable pageable =  PageRequest.of(page, size);
        return deviceRepository.findAll(pageable);
    }

    @Override
    public void save(Device device) {
        deviceRepository.save(device);
    }

}
