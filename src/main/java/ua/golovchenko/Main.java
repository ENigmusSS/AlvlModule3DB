package ua.golovchenko;

import ua.golovchenko.phoneoperator.entities.Abonent;
import ua.golovchenko.phoneoperator.repo.Hibernate.AbonentRepositoryImpl;
import ua.golovchenko.phoneoperator.repo.Hibernate.SMSRepositoryImpl;

import java.util.Scanner;

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
            default -> throw new IllegalArgumentException("Invalid command");
        }
    }

    private static void abonentBaseAccess() {
        System.out.println("to get all abonents information, press 1");
        System.out.println("to find abonent by number, press 2");
        System.out.println("to get statistics press 3");
        int command = scanner.nextInt();
        
    }

    private static void tariffBaseAccess() {
        System.out.println("for new tariff registration, press 1");
        System.out.println("to get all tariffs information, press 2");
        System.out.println("to find tariff by name, press 3");

    }

    private static void messageLogAccess() {
        System.out.println("to get complete SMS log information, press 1");
        System.out.println("to find message by ID, press 2");
        System.out.println("to search message log for signature text, press 3");
        int command = scanner.nextInt();
        switch (command) {
            case 1 ->  {
                SMSRepositoryImpl smsRepository = new SMSRepositoryImpl();
                smsRepository.getAll().forEach(System.out::println);
            }
            case 2 -> {
                SMSRepositoryImpl smsRepository = new SMSRepositoryImpl();
                System.out.println(smsRepository.getById(scanner.nextLine()));
            }
            case 3 -> {
                SMSRepositoryImpl smsRepository = new SMSRepositoryImpl();
                System.out.println(smsRepository.searchBySignature(scanner.nextLine()));
            }
        }
    }

    private static void deviceBaseAccess() {
        System.out.println("to get all devices information, press 1");
        System.out.println("to find device info by model name, press 2");
        System.out.println("to find most popular device, press 3");
    }

}