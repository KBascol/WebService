
package net.webservicex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetGeoIPContextResult" type="{http://www.webservicex.net/}GeoIP" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getGeoIPContextResult"
})
@XmlRootElement(name = "GetGeoIPContextResponse")
public class GetGeoIPContextResponse {

    @XmlElement(name = "GetGeoIPContextResult")
    protected GeoIP getGeoIPContextResult;

    /**
     * Obtient la valeur de la propriété getGeoIPContextResult.
     * 
     * @return
     *     possible object is
     *     {@link GeoIP }
     *     
     */
    public GeoIP getGetGeoIPContextResult() {
        return getGeoIPContextResult;
    }

    /**
     * Définit la valeur de la propriété getGeoIPContextResult.
     * 
     * @param value
     *     allowed object is
     *     {@link GeoIP }
     *     
     */
    public void setGetGeoIPContextResult(GeoIP value) {
        this.getGeoIPContextResult = value;
    }

}
