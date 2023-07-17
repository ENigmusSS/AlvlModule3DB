package ua.golovchenko.phoneoperator;

import ua.golovchenko.phoneoperator.entities.Abonent;
import ua.golovchenko.phoneoperator.entities.Device;
import ua.golovchenko.phoneoperator.entities.SMS;
import ua.golovchenko.phoneoperator.entities.Tariff;
import ua.golovchenko.phoneoperator.repo.AbonentRepository;
import ua.golovchenko.phoneoperator.repo.DeviceRepository;
import ua.golovchenko.phoneoperator.repo.Hibernate.AbonentRepositoryImpl;
import ua.golovchenko.phoneoperator.repo.Hibernate.DeviceRepositoryImpl;
import ua.golovchenko.phoneoperator.repo.Hibernate.TariffRepositoryImpl;
import ua.golovchenko.phoneoperator.repo.TariffRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class FakeBaseInit {
    private static String[] firstNames = {"Mary", "Maxim", "Svyatoslav", "Yaroslav", "Ivan", "Peter", "Vyacheslav", "Oleg", "Igor", "Olga", "Viktoria", "Iliya", "Alex", "Andry"};
    private static String[] lastNames = {"Petrenko", "Kovalchuk", "Shevchenko", "Lysenko", "Shapovalenko", "Kozlovskiy", "Melnik", "Vasylenko", "Honcharenko", "Ponomarenko"};
    private static Long nextNumber = 1666000000L;
    private static Random random = new Random();

    public static void fakeBaseInit() {
        createTariffs();
        createDevices();
        createAbonents();
    }

    private static void createTariffs() {
        TariffRepository tariffRepository = new TariffRepositoryImpl();
        tariffRepository.save(new Tariff("Cheap", 100, 2048, 100, 60, new ArrayList<>()));
        tariffRepository.save(new Tariff("Medium", 150, 5120, 200, 100, new ArrayList<>()));
        tariffRepository.save(new Tariff("Expensive", 200, 10240, 300, 200, new ArrayList<>()));
    }
    private static void createDevices() {
        DeviceRepository deviceRepository = new DeviceRepositoryImpl();
        deviceRepository.save(new Device("Samsung", new HashSet<>()));
        deviceRepository.save(new Device("iPhone", new HashSet<>()));
        deviceRepository.save(new Device("Xiaomi", new HashSet<>()));
    }
    private static void createAbonents() {
        AbonentRepository abonentRepository = new AbonentRepositoryImpl();
        DeviceRepository deviceRepository = new DeviceRepositoryImpl();
        TariffRepository tariffRepository = new TariffRepositoryImpl();
        List<Tariff> tariffs = tariffRepository.getAll();
        List<Device> devices = deviceRepository.getAll();
        for (int i = 0; i < 2000; i++) {
            Tariff nextTariff = tariffs.get(random.nextInt(0, tariffs.size()));
            HashSet<Device> abonentDevices = new HashSet<>();
            for (int j = 0; j < random.nextInt(1,3); j++) {
                abonentDevices.add(devices.get(random.nextInt(0, devices.size())));
            }
            abonentRepository.save(new Abonent(
                    nextNumber.toString(),
                    firstNames[random.nextInt(0, firstNames.length)],
                    lastNames[random.nextInt(0, lastNames.length)],
                    LocalDate.ofYearDay(random.nextInt(1980, 2005), random.nextInt(1, 365)),
                    nextTariff,
                    new ArrayList<>(),
                    random.nextLong(0, nextTariff.getCallsLimit()),
                    random.nextLong(0, nextTariff.getInternetTraffic()),
                    abonentDevices
                    ));
            nextNumber++;
        }
    }
}
