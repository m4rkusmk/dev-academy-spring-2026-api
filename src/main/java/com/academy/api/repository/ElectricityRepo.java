package com.academy.api.repository;

import com.academy.api.model.ElectricityData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ElectricityRepo extends JpaRepository <ElectricityData, String> {

    @Query(value = "SELECT\n" +
            "AVG(id) AS id,\n" +
            "date AS date,\n" +
            "null AS starttime,\n" +
            "SUM(productionamount) AS productionamount,\n" +
            "SUM(consumptionamount) AS consumptionamount,\n" +
            "AVG(hourlyprice) AS hourlyprice\n" +
            "FROM electricitydata\n" +
            "GROUP BY date\n" +
            "ORDER BY date asc", nativeQuery = true)
    ArrayList<ElectricityData> getDailyTotalData();

    @Query(value = "SELECT * FROM (\n" +
            "SELECT\n" +
            "AVG(id) AS id,\n" +
            "date AS date,\n" +
            "null AS starttime,\n" +
            "SUM(productionamount) AS productionamount,\n" +
            "SUM(consumptionamount) AS consumptionamount,\n" +
            "AVG(hourlyprice) AS hourlyprice\n" +
            "FROM electricitydata\n" +
            "GROUP BY date\n" +
            ") sub\n" +
            "WHERE hourlyprice >= :minprice\n" +
            "AND hourlyprice <= :maxprice\n" +
            "ORDER BY date asc", nativeQuery = true)
    ArrayList<ElectricityData> getDailyTotalDataByPriceRange(@Param("minprice") Double minprice,
                                                             @Param("maxprice") Double maxprice);


    @Query(value = "SELECT\n" +
            "AVG(id) AS id,\n" +
            "date AS date,\n" +
            "starttime as starttime,\n" +
            "SUM(productionamount) AS productionamount,\n" +
            "SUM(consumptionamount) AS consumptionamount,\n" +
            "AVG(hourlyprice) AS hourlyprice\n" +
            "FROM electricitydata\n" +
            "WHERE hourlyprice < 0\n" +
            "GROUP BY date, starttime \n" +
            "ORDER BY date, starttime", nativeQuery = true)
    ArrayList<ElectricityData> getMinusPriceData();


    @Query(value = "SELECT\n" +
            "AVG(id) AS id,\n" +
            "date AS date,\n" +
            "starttime AS starttime,\n" +
            "SUM(productionamount) AS productionamount,\n" +
            "SUM(consumptionamount) AS consumptionamount,\n" +
            "AVG(hourlyprice) AS hourlyprice\n" +
            "FROM electricitydata\n" +
            "WHERE CAST(date AS varchar) = :date\n" +
            "GROUP by date, starttime \n" +
            "ORDER BY date, starttime", nativeQuery = true)
    ArrayList<ElectricityData> getSingleDayData(@Param("date") String date);

    @Query(value = "SELECT\n" +
            "AVG(id) AS id,\n" +
            "date AS date,\n" +
            "null AS starttime,\n" +
            "null AS productionamount,\n" +
            "null AS consumptionamount,\n" +
            "null AS hourlyprice\n" +
            "FROM electricitydata\n" +
            "GROUP BY date\n" +
            "ORDER BY date", nativeQuery = true)
    ArrayList<ElectricityData> getDistinctDates();
}
