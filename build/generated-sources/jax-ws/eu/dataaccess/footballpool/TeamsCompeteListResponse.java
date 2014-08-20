
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
 *         &lt;element name="TeamsCompeteListResult" type="{http://footballpool.dataaccess.eu}ArrayOftTeamCompete"/>
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
    "teamsCompeteListResult"
})
@XmlRootElement(name = "TeamsCompeteListResponse")
public class TeamsCompeteListResponse {

    @XmlElement(name = "TeamsCompeteListResult", required = true)
    protected ArrayOftTeamCompete teamsCompeteListResult;

    /**
     * Obtiene el valor de la propiedad teamsCompeteListResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftTeamCompete }
     *     
     */
    public ArrayOftTeamCompete getTeamsCompeteListResult() {
        return teamsCompeteListResult;
    }

    /**
     * Define el valor de la propiedad teamsCompeteListResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftTeamCompete }
     *     
     */
    public void setTeamsCompeteListResult(ArrayOftTeamCompete value) {
        this.teamsCompeteListResult = value;
    }

}
