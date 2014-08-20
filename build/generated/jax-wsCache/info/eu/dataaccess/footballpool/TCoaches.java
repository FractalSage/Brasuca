
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tCoaches complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tCoaches">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TeamInfo" type="{http://footballpool.dataaccess.eu}tTeamInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCoaches", propOrder = {
    "sName",
    "teamInfo"
})
public class TCoaches {

    @XmlElement(required = true)
    protected String sName;
    @XmlElement(name = "TeamInfo", required = true)
    protected TTeamInfo teamInfo;

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
     * Obtiene el valor de la propiedad teamInfo.
     * 
     * @return
     *     possible object is
     *     {@link TTeamInfo }
     *     
     */
    public TTeamInfo getTeamInfo() {
        return teamInfo;
    }

    /**
     * Define el valor de la propiedad teamInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link TTeamInfo }
     *     
     */
    public void setTeamInfo(TTeamInfo value) {
        this.teamInfo = value;
    }

}
