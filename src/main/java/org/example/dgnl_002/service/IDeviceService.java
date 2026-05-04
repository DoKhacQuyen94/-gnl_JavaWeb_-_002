package org.example.dgnl_002.service;

import org.example.dgnl_002.model.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDeviceService {
    Page<Device> findAll(int  page, int size);
    void save(Device device);
}
