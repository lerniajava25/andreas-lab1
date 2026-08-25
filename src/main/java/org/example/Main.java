package org.example;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

                        LocalDate today = LocalDate.now();

                        DateTimeFormatter formatter =
                                DateTimeFormatter.ofPattern("MM-dd");

                        String formattedDate = today.format(formatter);

                        int year = today.getYear();

                        String url =
                                "https://www.elprisetjustnu.se/api/v1/prices/"
                                        + year
                                        + "/"
                                        + formattedDate
                                        + "_"
                                        + area
                                        + ".json";

                        HttpClient client = HttpClient.newHttpClient();

                        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(url))
                                .GET()
                                .build();

                        try {
                            HttpResponse<String> response = client.send(
                                    request,
                                    HttpResponse.BodyHandlers.ofString()
                            );

                            IO.println("Status code: " + response.statusCode());

                            Gson gson = new Gson();

                            ElectricityPrice[] prices = gson.fromJson(
                                    response.body(),
                                    ElectricityPrice[].class
                            );

                            for (ElectricityPrice price : prices) {
                                IO.println(price.getTimeStart() + " - " + price.getSekPerKwh());
                            }

                        } catch (Exception e) {
                            IO.println("Something went wrong when fetching prices.");
                        }

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