
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tTeamInfo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tTeamInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sCountryFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sWikipediaURL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sCountryFlagLarge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTeamInfo", propOrder = {
    "iId",
    "sName",
    "sCountryFlag",
    "sWikipediaURL",
    "sCountryFlagLarge"
})
public class TTeamInfo {

    protected int iId;
    @XmlElement(required = true)
    protected String sName;
    @XmlElement(required = true)
    protected String sCountryFlag;
    @XmlElement(required = true)
    protected String sWikipediaURL;
    @XmlElement(required = true)
    protected String sCountryFlagLarge;

    /**
     * Obtiene el valor de la propiedad iId.
     * 
     */
    public int getIId() {
        return iId;
    }

    /**
     * Define el valor de la propiedad iId.
     * 
     */
    public void setIId(int value) {
        this.iId = value;
    }

    /**
     * Obtiene el valor de la propiedad sName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSName() {
        return sName;
    }

    /**
     * Define el valor de la propiedad sName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSName(String value) {
        this.sName = value;
    }

    /**
     * Obtiene el valor de la propiedad sCountryFlag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCountryFlag() {
        return sCountryFlag;
    }

    /**
     * Define el valor de la propiedad sCountryFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCountryFlag(String value) {
        this.sCountryFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad sWikipediaURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSWikipediaURL() {
        return sWikipediaURL;
    }

    /**
     * Define el valor de la propiedad sWikipediaURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSWikipediaURL(String value) {
        this.sWikipediaURL = value;
    }

    /**
     * Obtiene el valor de la propiedad sCountryFlagLarge.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCountryFlagLarge() {
        return sCountryFlagLarge;
    }

    /**
     * Define el valor de la propiedad sCountryFlagLarge.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCountryFlagLarge(String value) {
        this.sCountryFlagLarge = value;
    }

}
