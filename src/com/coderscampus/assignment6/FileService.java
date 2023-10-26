package com.coderscampus.assignment6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class FileService {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy").withLocale(Locale.US);
	
	public List<SalesData> readFile(String filePath) throws IOException {
		
		return Files.lines(Paths.get(filePath))
					.skip(1)
					.map(line -> {
						String[] data = line.split(",");
						
						YearMonth yearMonth = YearMonth.parse(data[0], formatter);
                        LocalDate date = yearMonth.atDay(1); 
                        
					return new SalesData(date, Integer.parseInt(data[1].trim()));
				})  .collect(Collectors.toList());
	}

}
