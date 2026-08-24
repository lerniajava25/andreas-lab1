package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        String area = "";

        while (running) {

            IO.println("       [Electricity Price Checker]");
            IO.println("=========================================");
            IO.println("");
            IO.println("1. Choose area (SE1, SE2, SE3, SE4)");
            IO.println("2. Min, max and average price");
            IO.println("3. Sort prices (low to high)");
            IO.println("4. Best charging hours (4h consecutive)");
            IO.println("e. QUIT");

            IO.print("Your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    IO.print("Choose area (SE1, SE2, SE3, SE4): ");

                    String selectedArea = scanner.nextLine();

                    if (selectedArea.equalsIgnoreCase("SE1")
                            || selectedArea.equalsIgnoreCase("SE2")
                            || selectedArea.equalsIgnoreCase("SE3")
                            || selectedArea.equalsIgnoreCase("SE4")) {

                        area = selectedArea.toUpperCase();
                        IO.println("Selected area: " + area);

                    } else {
                        IO.println("Invalid area");
                    }
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
        scanner.close();
    }
}