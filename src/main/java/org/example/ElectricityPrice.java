package org.example;

import com.google.gson.annotations.SerializedName;
import java.time.OffsetDateTime;

public class ElectricityPrice {

    @SerializedName("SEK_per_kWh")
    private double sekPerKwh;

    @SerializedName("time_start")
    private String timeStart;

    public double getSekPerKwh() {
        return sekPerKwh;
    }

    public OffsetDateTime getParsedTimeStart() {
        return OffsetDateTime.parse(timeStart);
    }
}