
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GroupCompetitorsResult" type="{http://footballpool.dataaccess.eu}ArrayOftTeamInfo"/>
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
    "groupCompetitorsResult"
})
@XmlRootElement(name = "GroupCompetitorsResponse")
public class GroupCompetitorsResponse {

    @XmlElement(name = "GroupCompetitorsResult", required = true)
    protected ArrayOftTeamInfo groupCompetitorsResult;

    /**
     * Obtiene el valor de la propiedad groupCompetitorsResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftTeamInfo }
     *     
     */
    public ArrayOftTeamInfo getGroupCompetitorsResult() {
        return groupCompetitorsResult;
    }

    /**
     * Define el valor de la propiedad groupCompetitorsResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftTeamInfo }
     *     
     */
    public void setGroupCompetitorsResult(ArrayOftTeamInfo value) {
        this.groupCompetitorsResult = value;
    }

}
