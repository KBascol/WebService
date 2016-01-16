package application;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class IPLocationFinder {

	public static void main(String[] args) {
		GeoIPServiceSoap service = new GeoIPService().getGeoIPServiceSoap();
		GeoIP detIp;
		
		for(String ip : args) {
			detIp = service.getGeoIP(ip);
			System.out.println(ip + " -> " + detIp.getCountryCode() + " (" + detIp.getCountryName() + ")");
		}
	}
}
