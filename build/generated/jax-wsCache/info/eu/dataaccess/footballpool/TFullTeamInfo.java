
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tFullTeamInfo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tFullTeamInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sCountryFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sCountryFlagLarge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sCoach" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iCompeted" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sGoalKeepers" type="{http://footballpool.dataaccess.eu}ArrayOfString"/>
 *         &lt;element name="sDefenders" type="{http://footballpool.dataaccess.eu}ArrayOfString"/>
 *         &lt;element name="sMidFields" type="{http://footballpool.dataaccess.eu}ArrayOfString"/>
 *         &lt;element name="sForwards" type="{http://footballpool.dataaccess.eu}ArrayOfString"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tFullTeamInfo", propOrder = {
    "sName",
    "sCountryFlag",
    "sCountryFlagLarge",
    "sCoach",
    "iCompeted",
    "sGoalKeepers",
    "sDefenders",
    "sMidFields",
    "sForwards"
})
public class TFullTeamInfo {

    @XmlElement(required = true)
    protected String sName;
    @XmlElement(required = true)
    protected String sCountryFlag;
    @XmlElement(required = true)
    protected String sCountryFlagLarge;
    @XmlElement(required = true)
    protected String sCoach;
    protected int iCompeted;
    @XmlElement(required = true)
    protected ArrayOfString sGoalKeepers;
    @XmlElement(required = true)
    protected ArrayOfString sDefenders;
    @XmlElement(required = true)
    protected ArrayOfString sMidFields;
    @XmlElement(required = true)
    protected ArrayOfString sForwards;

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

    /**
     * Obtiene el valor de la propiedad sCoach.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSCoach() {
        return sCoach;
    }

    /**
     * Define el valor de la propiedad sCoach.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSCoach(String value) {
        this.sCoach = value;
    }

    /**
     * Obtiene el valor de la propiedad iCompeted.
     * 
     */
    public int getICompeted() {
        return iCompeted;
    }

    /**
     * Define el valor de la propiedad iCompeted.
     * 
     */
    public void setICompeted(int value) {
        this.iCompeted = value;
    }

    /**
     * Obtiene el valor de la propiedad sGoalKeepers.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getSGoalKeepers() {
        return sGoalKeepers;
    }

    /**
     * Define el valor de la propiedad sGoalKeepers.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setSGoalKeepers(ArrayOfString value) {
        this.sGoalKeepers = value;
    }

    /**
     * Obtiene el valor de la propiedad sDefenders.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getSDefenders() {
        return sDefenders;
    }

    /**
     * Define el valor de la propiedad sDefenders.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setSDefenders(ArrayOfString value) {
        this.sDefenders = value;
    }

    /**
     * Obtiene el valor de la propiedad sMidFields.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getSMidFields() {
        return sMidFields;
    }

    /**
     * Define el valor de la propiedad sMidFields.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setSMidFields(ArrayOfString value) {
        this.sMidFields = value;
    }

    /**
     * Obtiene el valor de la propiedad sForwards.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getSForwards() {
        return sForwards;
    }

    /**
     * Define el valor de la propiedad sForwards.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setSForwards(ArrayOfString value) {
        this.sForwards = value;
    }

}
