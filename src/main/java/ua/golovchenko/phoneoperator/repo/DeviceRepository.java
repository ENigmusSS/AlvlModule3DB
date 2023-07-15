package ua.golovchenko.phoneoperator.repo;

import ua.golovchenko.phoneoperator.entities.Device;

public interface DeviceRepository extends GenericRepository<Device>{
    public Device findMostPopularDevice();
}
