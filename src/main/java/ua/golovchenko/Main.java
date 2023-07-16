package ua.golovchenko;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            mainMenu();
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
            mainMenu();
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
        System.out.println("for new abonent registration, press 1");
        System.out.println("to get all abonents information, press 2");
        System.out.println("to find abonent by number, press 3");

    }

    private static void tariffBaseAccess() {
        System.out.println("for new tariff registration, press 1");
        System.out.println("to get all tariffs information, press 2");
        System.out.println("to find tariff by name, press 3");

    }

    private static void messageLogAccess() {
        System.out.println("for new message registration, press 1");
        System.out.println("to get complete SMS log information, press 2");
        System.out.println("to find message by ID, press 3");

    }

    private static void deviceBaseAccess() {
        System.out.println("for new device registration, press 1");
        System.out.println("to get all devices information, press 2");
        System.out.println("to find device info by model name, press 3");

    }

}