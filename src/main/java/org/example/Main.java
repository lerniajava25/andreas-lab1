package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        IO.println("       [Electricity Price Checker]");
        IO.println("=========================================");
        IO.println("");
        IO.println("1. Choose area (SE1, SE2, SE3, SE4)");
        IO.println("2. Min, max and average price");
        IO.println("3. Sort prices (low to high)");
        IO.println("4. Best charging hours (4h consecutive)");
        IO.println("e. QUIT");

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {

        IO.print("Your choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                IO.println("You chose area selection");
                break;

            case "2":
                IO.println("You chose Min, max and average price");
                break;

            case "3":
                IO.println("You chose Sort prices");
                break;

            case "4":
                IO.println("You chose best charging hours");
                break;

            case "e":
            case "E":
                IO.println("Exiting Program");
                running = false;
                break;

            default:
                IO.println("Invalid choice");
        }

    }
}}