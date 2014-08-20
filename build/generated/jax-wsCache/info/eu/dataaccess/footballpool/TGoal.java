
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para tGoal complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tGoal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dGame" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="iMinute" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sPlayerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sTeamName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sTeamFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sTeamFlagLarge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tGoal", propOrder = {
    "dGame",
    "iMinute",
    "sPlayerName",
    "sTeamName",
    "sTeamFlag",
    "sTeamFlagLarge"
})
public class TGoal {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dGame;
    protected int iMinute;
    @XmlElement(required = true)
    protected String sPlayerName;
    @XmlElement(required = true)
    protected String sTeamName;
    @XmlElement(required = true)
    protected String sTeamFlag;
    @XmlElement(required = true)
    protected String sTeamFlagLarge;

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
     * Obtiene el valor de la propiedad sTeamName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTeamName() {
        return sTeamName;
    }

    /**
     * Define el valor de la propiedad sTeamName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTeamName(String value) {
        this.sTeamName = value;
    }

    /**
     * Obtiene el valor de la propiedad sTeamFlag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTeamFlag() {
        return sTeamFlag;
    }

    /**
     * Define el valor de la propiedad sTeamFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTeamFlag(String value) {
        this.sTeamFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad sTeamFlagLarge.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTeamFlagLarge() {
        return sTeamFlagLarge;
    }

    /**
     * Define el valor de la propiedad sTeamFlagLarge.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTeamFlagLarge(String value) {
        this.sTeamFlagLarge = value;
    }

}
