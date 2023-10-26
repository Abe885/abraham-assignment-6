package com.coderscampus.assignment6;

import java.time.LocalDate;
import java.util.Objects;

public class SalesData {

	private LocalDate date;
	private Integer sales;

	@Override
	public int hashCode() {
		return Objects.hash(date, sales);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesData other = (SalesData) obj;
		return Objects.equals(date, other.date) && Objects.equals(sales, other.sales);
	}

	public SalesData(LocalDate date, Integer sales) {
		
		this.date = date;
		this.sales = sales;
	}

	public LocalDate getDate() {
		return date;
	}

	public Integer getSales() {
		return sales;
	}

	@Override
	public String toString() {
		return date + " -> " + sales;
	}

}