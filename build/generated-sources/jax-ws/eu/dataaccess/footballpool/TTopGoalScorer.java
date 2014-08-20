
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tTopGoalScorer complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tTopGoalScorer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iGoals" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sCountry" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sFlagLarge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTopGoalScorer", propOrder = {
    "sName",
    "iGoals",
    "sCountry",
    "sFlag",
    "sFlagLarge"
})
public class TTopGoalScorer {

    @XmlElement(required = true)
    protected String sName;
    protected int iGoals;
    @XmlElement(required = true)
    protected String sCountry;
    @XmlElement(required = true)
    protected String sFlag;
    @XmlElement(required = true)
    protected String sFlagLarge;

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
     * Obtiene el valor de la propiedad iGoals.
     * 
     */
    public int getIGoals() {
        return iGoals;
    }

    /**
     * Define el valor de la propiedad iGoals.
     * 
     */
    public void setIGoals(int value) {
        this.iGoals = value;
    }

    /**
     * Obtiene el valor de la propiedad sCountry.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCountry() {
        return sCountry;
    }

    /**
     * Define el valor de la propiedad sCountry.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCountry(String value) {
        this.sCountry = value;
    }

    /**
     * Obtiene el valor de la propiedad sFlag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFlag() {
        return sFlag;
    }

    /**
     * Define el valor de la propiedad sFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFlag(String value) {
        this.sFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad sFlagLarge.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFlagLarge() {
        return sFlagLarge;
    }

    /**
     * Define el valor de la propiedad sFlagLarge.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFlagLarge(String value) {
        this.sFlagLarge = value;
    }

}
