package com.coderscampus.assignment6;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalesDataOuputter {
	public void outputSalesData(List<SalesData> salesDataList, String modelName) {
		
		Map<Integer, Integer> yearlySales = salesDataList.stream().collect(
				Collectors.groupingBy(data -> data.getDate().getYear(), Collectors.summingInt(SalesData::getSales)));

		Optional<SalesData> bestMonth = salesDataList.stream().max(Comparator.comparingInt(SalesData::getSales));

		Optional<SalesData> worstMonth = salesDataList.stream().min(Comparator.comparingInt(SalesData::getSales));

        System.out.println(modelName + " Yearly Sales Report");
        System.out.println("---------------------------");
        yearlySales.forEach((year, sales) -> System.out.println(year + " -> " + sales));
        System.out.println("");
        bestMonth.ifPresent(data -> System.out.println("The best month for " + modelName + " was: " + data.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM"))));
        worstMonth.ifPresent(data -> System.out.println("The worst month for " + modelName + " was: " + data.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM"))));
    }
}