
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para tTournamentInfo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tTournamentInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dFirstGame" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="dLastGame" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="dLastGroupDateGame" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="iGames" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTournamentInfo", propOrder = {
    "dFirstGame",
    "dLastGame",
    "dLastGroupDateGame",
    "iGames"
})
public class TTournamentInfo {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dFirstGame;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dLastGame;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dLastGroupDateGame;
    protected int iGames;

    /**
     * Obtiene el valor de la propiedad dFirstGame.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDFirstGame() {
        return dFirstGame;
    }

    /**
     * Define el valor de la propiedad dFirstGame.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDFirstGame(XMLGregorianCalendar value) {
        this.dFirstGame = value;
    }

    /**
     * Obtiene el valor de la propiedad dLastGame.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDLastGame() {
        return dLastGame;
    }

    /**
     * Define el valor de la propiedad dLastGame.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDLastGame(XMLGregorianCalendar value) {
        this.dLastGame = value;
    }

    /**
     * Obtiene el valor de la propiedad dLastGroupDateGame.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDLastGroupDateGame() {
        return dLastGroupDateGame;
    }

    /**
     * Define el valor de la propiedad dLastGroupDateGame.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDLastGroupDateGame(XMLGregorianCalendar value) {
        this.dLastGroupDateGame = value;
    }

    /**
     * Obtiene el valor de la propiedad iGames.
     * 
     */
    public int getIGames() {
        return iGames;
    }

    /**
     * Define el valor de la propiedad iGames.
     * 
     */
    public void setIGames(int value) {
        this.iGames = value;
    }

}
