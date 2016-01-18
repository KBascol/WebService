package org.bascollaoussing.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService
public class MyCurrencyConvertor {
	List<String> currenciesList = new ArrayList<String>();
	
	
	public void initializeList() {
		currenciesList.add("euro");
		currenciesList.add("dollar");
		currenciesList.add("yen");
	}
	
	public List<String> getCurrenciesList() {
		if(currenciesList.isEmpty()) {
			initializeList();
		}
		
		return currenciesList;
	}
	
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
	
	public boolean addCurrency(String name) {
		return currenciesList.add(name);
	}
}
