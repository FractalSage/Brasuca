
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
 *         &lt;element name="TournamentInfoResult" type="{http://footballpool.dataaccess.eu}tTournamentInfo"/>
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
    "tournamentInfoResult"
})
@XmlRootElement(name = "TournamentInfoResponse")
public class TournamentInfoResponse {

    @XmlElement(name = "TournamentInfoResult", required = true)
    protected TTournamentInfo tournamentInfoResult;

    /**
     * Obtiene el valor de la propiedad tournamentInfoResult.
     * 
     * @return
     *     possible object is
     *     {@link TTournamentInfo }
     *     
     */
    public TTournamentInfo getTournamentInfoResult() {
        return tournamentInfoResult;
    }

    /**
     * Define el valor de la propiedad tournamentInfoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link TTournamentInfo }
     *     
     */
    public void setTournamentInfoResult(TTournamentInfo value) {
        this.tournamentInfoResult = value;
    }

}
