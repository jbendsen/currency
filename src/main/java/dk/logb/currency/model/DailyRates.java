package dk.logb.currency.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DailyRates {
	private LocalDate date;
	private Map<String, Double> rates = new HashMap();

	
	public DailyRates(LocalDate date) {
		super();
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "DailyRates [date=" + date + ", rates=" + rates + "]";
	}
	
	

}
