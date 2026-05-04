package org.example.dgnl_002.repository;

import org.example.dgnl_002.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeviceRepository extends JpaRepository<Device, Long> {
}
