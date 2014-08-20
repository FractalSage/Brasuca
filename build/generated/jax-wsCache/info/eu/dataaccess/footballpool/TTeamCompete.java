
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tTeamCompete complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tTeamCompete">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iCompeted" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="iWon" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CoachInfo" type="{http://footballpool.dataaccess.eu}tCoaches"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTeamCompete", propOrder = {
    "iCompeted",
    "iWon",
    "coachInfo"
})
public class TTeamCompete {

    protected int iCompeted;
    protected int iWon;
    @XmlElement(name = "CoachInfo", required = true)
    protected TCoaches coachInfo;

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
     * Obtiene el valor de la propiedad iWon.
     * 
     */
    public int getIWon() {
        return iWon;
    }

    /**
     * Define el valor de la propiedad iWon.
     * 
     */
    public void setIWon(int value) {
        this.iWon = value;
    }

    /**
     * Obtiene el valor de la propiedad coachInfo.
     * 
     * @return
     *     possible object is
     *     {@link TCoaches }
     *     
     */
    public TCoaches getCoachInfo() {
        return coachInfo;
    }

    /**
     * Define el valor de la propiedad coachInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link TCoaches }
     *     
     */
    public void setCoachInfo(TCoaches value) {
        this.coachInfo = value;
    }

}
