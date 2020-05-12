package dk.logb.currency.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;

import org.gesmes.xml._2002_08_01.EnvelopeType;

import _int.ecb.vocabulary._2002_08_01.eurofxref.CurrencyCube;
import _int.ecb.vocabulary._2002_08_01.eurofxref.TimeCube;
import dk.logb.currency.model.DailyRates;
import dk.logb.currency.model.DailyRatesList;


public class CurrencyService {
	
	public DailyRatesList getRates() {		
		DailyRatesList list = new DailyRatesList();
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
			
		
		try {
			String xml = getResourceAsString(
					"http://www.nationalbanken.dk/_vti_bin/DN/DataService.svc/CurrencyRatesHistoryXML?lang=en");
			JAXBContext ctx = JAXBContext.newInstance("org.gesmes.xml._2002_08_01");
			Unmarshaller unm = ctx.createUnmarshaller();
			JAXBElement<EnvelopeType> env = (JAXBElement) unm.unmarshal(new StringReader(xml));
	
			List<TimeCube> cubes = env.getValue().getCube().getCube();
			for (TimeCube c : cubes) {
				XMLGregorianCalendar xmlDate = c.getTime();
				LocalDate d = LocalDate.of(xmlDate.getYear(), xmlDate.getMonth(), xmlDate.getDay());
				DailyRates dailyRates = new DailyRates(d);
				list.getDates().add(dailyRates);
				List<CurrencyCube> cubes2 = c.getCube();
				for (CurrencyCube c2 : cubes2) {
					dailyRates.getRates().put(c2.getCurrency(), (double)((int)(c2.getRate()*100)/100.0));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return list;
	}
	
	public static String getResourceAsString(String url) throws Exception {
		URL website = new URL(url);
		URLConnection connection = website.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		StringBuilder response = new StringBuilder();
		String inputLine;

		while ((inputLine = in.readLine()) != null)
			response.append(inputLine + "\n");

		in.close();

		return response.toString();
	}
}
