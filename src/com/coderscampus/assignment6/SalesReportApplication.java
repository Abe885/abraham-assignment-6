package com.coderscampus.assignment6;

import java.io.IOException;
import java.util.List;

public class SalesReportApplication {
	private static String modelSFilePath = "modelS.csv";
	private static String model3FilePath = "model3.csv";
	private static String modelXFilePath = "modelX.csv";

	public static void main(String[] args) {
		
		FileService fileService = new FileService();
		SalesDataOuputter salesReport = new SalesDataOuputter();

		try {
			List<SalesData> model3Sales = fileService.readFile(model3FilePath);
			List<SalesData> modelSSales = fileService.readFile(modelSFilePath);
			List<SalesData> modelXSales = fileService.readFile(modelXFilePath);

			salesReport.outputSalesData(model3Sales, "Model 3");
			salesReport.outputSalesData(modelSSales, "Model S");
			salesReport.outputSalesData(modelXSales, "Model X");
		} catch (IOException e) {
			System.out.println("Error reading the file: " + e.getMessage());
		}
	}

}