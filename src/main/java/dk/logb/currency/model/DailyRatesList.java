package dk.logb.currency.model;

import java.util.ArrayList;
import java.util.List;

public class DailyRatesList {
	private List<DailyRates> rates = new ArrayList();

	public List<DailyRates> getRates() {
		return rates;
	}

	public void setRates(List<DailyRates> rates) {
		this.rates = rates;
	}

	public DailyRatesList() {
		super();		
	}

	@Override
	public String toString() {
		return "DailyRatesList [rates=" + rates + "]";
	}

}
