
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para tCardInfo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tCardInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dGame" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="iMinute" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sGameTeam1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sGameTeam2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sPlayerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="bYellowCard" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bRedCard" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sGameTeam1Flag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sGameTeam1FlagLarge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sGameTeam2Flag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sGameTeam2FlagLarge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sPlayerFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sPlayerFlagLarge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCardInfo", propOrder = {
    "dGame",
    "iMinute",
    "sGameTeam1",
    "sGameTeam2",
    "sPlayerName",
    "bYellowCard",
    "bRedCard",
    "sGameTeam1Flag",
    "sGameTeam1FlagLarge",
    "sGameTeam2Flag",
    "sGameTeam2FlagLarge",
    "sPlayerFlag",
    "sPlayerFlagLarge"
})
public class TCardInfo {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dGame;
    protected int iMinute;
    @XmlElement(required = true)
    protected String sGameTeam1;
    @XmlElement(required = true)
    protected String sGameTeam2;
    @XmlElement(required = true)
    protected String sPlayerName;
    protected boolean bYellowCard;
    protected boolean bRedCard;
    @XmlElement(required = true)
    protected String sGameTeam1Flag;
    @XmlElement(required = true)
    protected String sGameTeam1FlagLarge;
    @XmlElement(required = true)
    protected String sGameTeam2Flag;
    @XmlElement(required = true)
    protected String sGameTeam2FlagLarge;
    @XmlElement(required = true)
    protected String sPlayerFlag;
    @XmlElement(required = true)
    protected String sPlayerFlagLarge;

    /**
     * Obtiene el valor de la propiedad dGame.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDGame() {
        return dGame;
    }

    /**
     * Define el valor de la propiedad dGame.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDGame(XMLGregorianCalendar value) {
        this.dGame = value;
    }

    /**
     * Obtiene el valor de la propiedad iMinute.
     * 
     */
    public int getIMinute() {
        return iMinute;
    }

    /**
     * Define el valor de la propiedad iMinute.
     * 
     */
    public void setIMinute(int value) {
        this.iMinute = value;
    }

    /**
     * Obtiene el valor de la propiedad sGameTeam1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSGameTeam1() {
        return sGameTeam1;
    }

    /**
     * Define el valor de la propiedad sGameTeam1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSGameTeam1(String value) {
        this.sGameTeam1 = value;
    }

    /**
     * Obtiene el valor de la propiedad sGameTeam2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSGameTeam2() {
        return sGameTeam2;
    }

    /**
     * Define el valor de la propiedad sGameTeam2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSGameTeam2(String value) {
        this.sGameTeam2 = value;
    }

    /**
     * Obtiene el valor de la propiedad sPlayerName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPlayerName() {
        return sPlayerName;
    }

    /**
     * Define el valor de la propiedad sPlayerName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPlayerName(String value) {
        this.sPlayerName = value;
    }

    /**
     * Obtiene el valor de la propiedad bYellowCard.
     * 
     */
    public boolean isBYellowCard() {
        return bYellowCard;
    }

    /**
     * Define el valor de la propiedad bYellowCard.
     * 
     */
    public void setBYellowCard(boolean value) {
        this.bYellowCard = value;
    }

    /**
     * Obtiene el valor de la propiedad bRedCard.
     * 
     */
    public boolean isBRedCard() {
        return bRedCard;
    }

    /**
     * Define el valor de la propiedad bRedCard.
     * 
     */
    public void setBRedCard(boolean value) {
        this.bRedCard = value;
    }

    /**
     * Obtiene el valor de la propiedad sGameTeam1Flag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSGameTeam1Flag() {
        return sGameTeam1Flag;
    }

    /**
     * Define el valor de la propiedad sGameTeam1Flag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSGameTeam1Flag(String value) {
        this.sGameTeam1Flag = value;
    }

    /**
     * Obtiene el valor de la propiedad sGameTeam1FlagLarge.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSGameTeam1FlagLarge() {
        return sGameTeam1FlagLarge;
    }

    /**
     * Define el valor de la propiedad sGameTeam1FlagLarge.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSGameTeam1FlagLarge(String value) {
        this.sGameTeam1FlagLarge = value;
    }

    /**
     * Obtiene el valor de la propiedad sGameTeam2Flag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSGameTeam2Flag() {
        return sGameTeam2Flag;
    }

    /**
     * Define el valor de la propiedad sGameTeam2Flag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSGameTeam2Flag(String value) {
        this.sGameTeam2Flag = value;
    }

    /**
     * Obtiene el valor de la propiedad sGameTeam2FlagLarge.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSGameTeam2FlagLarge() {
        return sGameTeam2FlagLarge;
    }

    /**
     * Define el valor de la propiedad sGameTeam2FlagLarge.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSGameTeam2FlagLarge(String value) {
        this.sGameTeam2FlagLarge = value;
    }

    /**
     * Obtiene el valor de la propiedad sPlayerFlag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPlayerFlag() {
        return sPlayerFlag;
    }

    /**
     * Define el valor de la propiedad sPlayerFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPlayerFlag(String value) {
        this.sPlayerFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad sPlayerFlagLarge.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPlayerFlagLarge() {
        return sPlayerFlagLarge;
    }

    /**
     * Define el valor de la propiedad sPlayerFlagLarge.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPlayerFlagLarge(String value) {
        this.sPlayerFlagLarge = value;
    }

}
