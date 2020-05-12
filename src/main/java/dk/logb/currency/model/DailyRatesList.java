package dk.logb.currency.model;

import java.util.ArrayList;
import java.util.List;

public class DailyRatesList {
	private List<DailyRates> dates = new ArrayList();

	public List<DailyRates> getDates() {
		return dates;
	}

	public void setDates(List<DailyRates> rates) {
		this.dates = rates;
	}

	public DailyRatesList() {
		super();		
	}

	@Override
	public String toString() {
		return "DailyRatesList [rates=" + dates + "]";
	}

}
