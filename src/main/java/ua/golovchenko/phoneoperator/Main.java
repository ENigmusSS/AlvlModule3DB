package ua.golovchenko.phoneoperator;

import ua.golovchenko.phoneoperator.repo.AbonentRepository;
import ua.golovchenko.phoneoperator.repo.DeviceRepository;
import ua.golovchenko.phoneoperator.repo.Hibernate.AbonentRepositoryImpl;
import ua.golovchenko.phoneoperator.repo.Hibernate.DeviceRepositoryImpl;
import ua.golovchenko.phoneoperator.repo.Hibernate.SMSRepositoryImpl;
import ua.golovchenko.phoneoperator.repo.Hibernate.TariffRepositoryImpl;
import ua.golovchenko.phoneoperator.repo.SMSRepository;
import ua.golovchenko.phoneoperator.repo.TariffRepository;

import java.util.Scanner;

import static ua.golovchenko.phoneoperator.FakeBaseInit.fakeBaseInit;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                mainMenu();
            } catch (IllegalArgumentException exception) {
                System.err.println(exception.getMessage());
            }
        }
    }

    private static void mainMenu() throws IllegalArgumentException {
        System.out.println("For reinitialize Base press 0");
        System.out.println("For Abonents base access press 1");
        System.out.println("For Tariffs base access press 2");
        System.out.println("For SMS log access press 3");
        System.out.println("For Devices base access press 4");
        int command = scanner.nextInt();
        switch (command) {
            case 1 -> abonentBaseAccess();
            case 2 -> tariffBaseAccess();
            case 3 -> messageLogAccess();
            case 4 -> deviceBaseAccess();
            case 0 -> fakeBaseInit();
            default -> throw new IllegalArgumentException("Invalid command");
        }
    }

    private static void abonentBaseAccess() throws IllegalArgumentException {
        AbonentRepository abonentRepository = new AbonentRepositoryImpl();
        System.out.println("to get all abonents information, press 1");
        System.out.println("to find abonent by number, press 2");
        System.out.println("to get statistics press 3");
        int command = scanner.nextInt();
        switch (command) {
            case 1 -> abonentRepository.getAll().forEach(System.out::println);
            case 2 -> System.out.println(abonentRepository.getById(scanner.nextLine()));
            case 3 -> {
                System.out.println("top5: callers 1, traffic consumers 2, texters 3; service summary 4");
                command = scanner.nextInt();
                switch (command) {
                    case 1 -> abonentRepository.getTop5Callers().forEach(System.out::println);
                    case 2 -> abonentRepository.getTop5Traffic().forEach(System.out::println);
                    case 3 -> abonentRepository.getTop5Texters().forEach(System.out::println);
                    case 4 -> abonentRepository.compareServicePopularity();
                    default -> throw new IllegalArgumentException("invalid command");
                }
            }
            default -> throw new IllegalArgumentException("invalid command");
        }
    }

    private static void tariffBaseAccess() throws IllegalArgumentException {
        TariffRepository tariffRepository = new TariffRepositoryImpl();
        System.out.println("to get all tariffs information, press 1");
        System.out.println("to find tariff by name, press 2");
        int command = scanner.nextInt();
        switch (command) {
            case 1 -> tariffRepository.getAll().forEach(System.out::println);
            case 2 -> tariffRepository.getById(scanner.nextLine());
            default -> throw new IllegalArgumentException("invalid command");
        }
    }

    private static void messageLogAccess() throws IllegalArgumentException {
        SMSRepository smsRepository = new SMSRepositoryImpl();
        System.out.println("to get complete SMS log information, press 1");
        System.out.println("to find message by ID, press 2");
        System.out.println("to search message log for signature text, press 3");
        int command = scanner.nextInt();
        switch (command) {
            case 1 -> smsRepository.getAll().forEach(System.out::println);
            case 2 -> System.out.println(smsRepository.getById(scanner.nextLine()));
            case 3 -> System.out.println(smsRepository.searchBySignature(scanner.nextLine()));
            default -> throw new IllegalArgumentException("Invalid command");
        }
    }

    private static void deviceBaseAccess() throws  IllegalArgumentException {
        DeviceRepository deviceRepository = new DeviceRepositoryImpl();
        System.out.println("to get all devices information, press 1");
        System.out.println("to find device info by model name, press 2");
        System.out.println("to find most popular device, press 3");
        int command = scanner.nextInt();
        switch (command) {
            case 1 -> deviceRepository.getAll().forEach(System.out::println);
            case 2 -> System.out.println(deviceRepository.getById(scanner.nextLine()));
            case 3 -> System.out.println(deviceRepository.findMostPopularDevice());
            default -> throw new IllegalArgumentException("invalid command");
        }
    }

}