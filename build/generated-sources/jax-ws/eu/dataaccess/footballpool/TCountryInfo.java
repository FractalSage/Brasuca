
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tCountryInfo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tCountryInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sIsoCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iPersons" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCountryInfo", propOrder = {
    "iId",
    "sName",
    "sIsoCode",
    "iPersons"
})
public class TCountryInfo {

    protected int iId;
    @XmlElement(required = true)
    protected String sName;
    @XmlElement(required = true)
    protected String sIsoCode;
    protected int iPersons;

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
     * Obtiene el valor de la propiedad sIsoCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIsoCode() {
        return sIsoCode;
    }

    /**
     * Define el valor de la propiedad sIsoCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIsoCode(String value) {
        this.sIsoCode = value;
    }

    /**
     * Obtiene el valor de la propiedad iPersons.
     * 
     */
    public int getIPersons() {
        return iPersons;
    }

    /**
     * Define el valor de la propiedad iPersons.
     * 
     */
    public void setIPersons(int value) {
        this.iPersons = value;
    }

}
