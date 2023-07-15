package ua.golovchenko.phoneoperator.repo.Hibernate;

import ua.golovchenko.phoneoperator.entities.Device;
import ua.golovchenko.phoneoperator.repo.DeviceRepository;

public class DeviceRepositoryImpl extends GenericRepositoryImpl<Device> implements DeviceRepository {
    @Override
    protected void init() {
        aClass = Device.class;
    }


}
