package com.academy.api.controller;

import com.academy.api.model.ElectricityData;
import com.academy.api.repository.ElectricityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin
@RestController
public class ElectricityController {

    @Autowired
    private ElectricityRepo electricityRepo;


    @GetMapping("/api/electricity/getDailyTotalData")
    public ArrayList<ElectricityData> getDailyTotalData() {

        return electricityRepo.getDailyTotalData();
    }

    @GetMapping("/api/electricity/getDailyTotalDataByPriceRange/{minprice}/{maxprice}")
    public ArrayList<ElectricityData> getDailyTotalDataByPriceRange(@PathVariable Double minprice,
                                                                    @PathVariable Double maxprice) {

        return electricityRepo.getDailyTotalDataByPriceRange(minprice, maxprice);
    }

    @GetMapping("api/electricity/getMinusPriceData")
    public ArrayList<ElectricityData> getMinusPriceData() {

        return electricityRepo.getMinusPriceData();
    }

    @GetMapping("api/electricity/getSingleDayData/{date}")
    public ArrayList<ElectricityData> getSingleDayData(@PathVariable String date) {

        return electricityRepo.getSingleDayData(date);
    }

    @GetMapping("api/electricity/getDistinctDates")
    public ArrayList<ElectricityData> getDistinctDates() {

        return electricityRepo.getDistinctDates();
    }

}
