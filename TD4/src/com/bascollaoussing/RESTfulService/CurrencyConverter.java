package com.bascollaoussing.RESTfulService;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.bascollaoussing.model.Currency;
import com.rest.DB.DBClass;

@Path("currencyConverter")
public class CurrencyConverter {
	private String version = "0.1";
	private static List<Currency> currencyList = new ArrayList<Currency>();
	
	@GET
	@Path("currency/{identifier:[0-9]*}")
	public String currency(@PathParam("identifier") int identifier) {
		int id = identifier-1;
		int size;
		
		if(currencyList.isEmpty()) {
			initializeCurrencies();
		}
		
		size = currencyList.size();
		if(id >= size || id < 0) {
			return "[Erreur] id " + identifier + " hors tableau (max id: " + size + ")";
		}
		
		return currencyList.get(id).getName();
	}
	
	@GET
	@Path("version")
	public String version() {
		return "-- The current version is " +version + " --";
	}
	
	private static void initializeCurrencies() {
		currencyList.add(new Currency("USA", "Dollar", 1800,1));
		currencyList.add(new Currency("EU","Euro",2000,2));
		currencyList.add(new Currency("Japan", "Yen",1945,3));
	}
	
	@GET
	@Path("conversion/{source}/{destination}/{amount:[0-9]+}")
	public double convert (@PathParam("source") String source, @PathParam("destination") String destination, @PathParam("amount") double amount) {
		if("E".equals(source)) {
			if("D".equals(destination)) {
				return amount*1.0817;
			}
			if("Y".equals(destination)) {
				return amount*128.117968;
			}
		}
		if("D".equals(source)) {
			if("E".equals(destination)) {
				return amount*0.924470741;
			}
			if("Y".equals(destination)) {
				return amount*118.441312;
			}
		}
		if("Y".equals(source)) {
			if("E".equals(destination)) {
				return amount*0.00780530646;
			}
			if("D".equals(destination)) {
				return amount*0.008443;
			}
		}
		
		return -1;
	}
	
	@GET
	@Path("currencies")
	@Produces(MediaType.TEXT_XML)
	public List<Currency> getCurrenciesXML(@QueryParam("sortedYN") String sort) {
		if(currencyList.isEmpty()) {
			initializeCurrencies();
		}
		
		if(sort != null && "y".equals(sort)) {
			Collections.sort(currencyList, new Comparator<Currency>() {
		        @Override
		        public int compare(Currency  fruite1, Currency  fruite2)
		        {

		            return  fruite1.getName().compareTo(fruite2.getName());
		        }
		    });
		}
		
		return currencyList;
	}

	@GET
	@Path("currencies")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Currency> getCurrenciesJSON(@QueryParam("sortedYN") String sort) {
		if(currencyList.isEmpty()) {
			initializeCurrencies();
		}
		
		if(sort != null && "y".equals(sort)) {
			Collections.sort(currencyList, new Comparator<Currency>() {
		        @Override
		        public int compare(Currency  fruite1, Currency  fruite2)
		        {

		            return  fruite1.getName().compareTo(fruite2.getName());
		        }
		    });
		}
		return currencyList;
	}
	
	@GET
	@Path("offices")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOffices() {
		Connection connexion = DBClass.returnConnection();
		ResultSet set;
		
		try {
			set = connexion.createStatement().executeQuery("SELECT * FROM office;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return version;
	}
}
