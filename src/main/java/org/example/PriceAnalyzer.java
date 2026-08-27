package org.example;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;



public class PriceAnalyzer {

    public static void printBestChargingWindow(ElectricityPrice[] prices) {

        int windowSize = 16;

        double currentSum = 0;

        for (int i = 0; i < windowSize; i++) {
            currentSum = currentSum + prices[i].getSekPerKwh();
        }

        double lowestSum = currentSum;
        int bestStartIndex = 0;

        for (int i = windowSize; i < prices.length; i++) {

            currentSum = currentSum
                    - prices[i - windowSize].getSekPerKwh()
                    + prices[i].getSekPerKwh();

            if (currentSum < lowestSum) {
                lowestSum = currentSum;
                bestStartIndex = i - windowSize + 1;
            }
        }

        DateTimeFormatter timeFormatter =
                DateTimeFormatter.ofPattern("HH:mm");

        String startTime =
                prices[bestStartIndex]
                        .getParsedTimeStart()
                        .format(timeFormatter);

        String endTime =
                prices[bestStartIndex + windowSize - 1]
                        .getParsedTimeStart()
                        .plusMinutes(15)
                        .format(timeFormatter);

        double averagePrice =
                lowestSum / windowSize * 100;

        IO.println("Best charging time: "
                + startTime
                + " - "
                + endTime);

        IO.println(
                String.format(
                        "Average price: %.2f öre/kWh",
                        averagePrice
                )
        );
    }


    public static void printPriceAnalysis(ElectricityPrice[] prices) {

        double total = 0;

        double min = prices[0].getSekPerKwh();
        double max = prices[0].getSekPerKwh();

        for (ElectricityPrice price : prices) {

            double currentPrice = price.getSekPerKwh();

            total = total + currentPrice;

            if (currentPrice < min) {
                min = currentPrice;
            }

            if (currentPrice > max) {
                max = currentPrice;
            }
        }



        double average = total / prices.length;

        double minOre = min * 100;
        double maxOre = max * 100;
        double averageOre = average * 100;

        IO.println(String.format("Min price: %.2f öre/kWh", minOre));
        IO.println(String.format("Max price: %.2f öre/kWh", maxOre));
        IO.println(String.format("Average price: %.2f öre/kWh", averageOre));
    }
    public static void printSortedPrices(ElectricityPrice[] prices) {

        DateTimeFormatter timeFormatter =
                DateTimeFormatter.ofPattern("HH:mm");

        ElectricityPrice[] sortedPrices = prices.clone();

        Arrays.sort(
                sortedPrices,
                (a, b) -> Double.compare(
                        a.getSekPerKwh(),
                        b.getSekPerKwh()
                )
        );

        for (ElectricityPrice price : sortedPrices) {

            double ore = price.getSekPerKwh() * 100;

            String formattedTime =
                    price.getParsedTimeStart().format(timeFormatter);

            IO.println(
                    formattedTime
                            + " - "
                            + String.format("%.2f", ore)
                            + " öre/kWh"
            );
        }
    }
}