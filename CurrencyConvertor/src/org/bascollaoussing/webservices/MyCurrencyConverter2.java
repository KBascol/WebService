package org.bascollaoussing.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public class MyCurrencyConverter2 {
List<Currency> currenciesList = new ArrayList<Currency>();
	
	public void initializeList() {
		currenciesList.add(new Currency("euro", "UE", 1999));
		currenciesList.add(new Currency("dollar", "USA", 1785));
		currenciesList.add(new Currency("yen", "Japon", 1871));
	}
	
	public List<Currency> getCurrenciesList() {
		if(currenciesList.isEmpty()) {
			initializeList();
		}
		
		return currenciesList;
	}
	
	@WebMethod(exclude=true)
	public double convert ( String source, String destination, double amount) {
		if("euro".equals(source)) {
			if("dollar".equals(destination)) {
				return amount*1.08945;
			}
			if("yen".equals(destination)) {
				return amount*127.615087;
			}
		}
		if("dollar".equals(source)) {
			if("euro".equals(destination)) {
				return amount*0.91789435;
			}
			if("yen".equals(destination)) {
				return amount*117.137168;
			}
		}
		if("yen".equals(source)) {
			if("euro".equals(destination)) {
				return amount*0.00783606407;
			}
			if("dollar".equals(destination)) {
				return amount*0.008537;
			}
		}
		
		return -1;
	}
	
	@WebMethod(exclude=true)
	public boolean addCurrency(Currency curr) {
		return currenciesList.add(curr);
	}
}
