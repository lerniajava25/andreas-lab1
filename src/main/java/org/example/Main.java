package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        IO.println("Electricity Price Checker");
        IO.println("=========================");
        IO.println("");
        IO.println("1. Choose area (SE1, SE2, SE3, SE4)");
        IO.println("2. Min, max and average price");
        IO.println("3. Sort prices (low to high)");
        IO.println("4. Best charging hours (4h consecutive)");
        IO.println("e. QUIT");

        Scanner scanner = new Scanner(System.in);
        IO.print("Your choice: ");
        String choice = scanner.nextLine();
        IO.println("You chose: " + choice);

    }
}