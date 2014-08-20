
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
 *         &lt;element name="GameInfoResult" type="{http://footballpool.dataaccess.eu}tGameInfo"/>
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
    "gameInfoResult"
})
@XmlRootElement(name = "GameInfoResponse")
public class GameInfoResponse {

    @XmlElement(name = "GameInfoResult", required = true)
    protected TGameInfo gameInfoResult;

    /**
     * Obtiene el valor de la propiedad gameInfoResult.
     * 
     * @return
     *     possible object is
     *     {@link TGameInfo }
     *     
     */
    public TGameInfo getGameInfoResult() {
        return gameInfoResult;
    }

    /**
     * Define el valor de la propiedad gameInfoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link TGameInfo }
     *     
     */
    public void setGameInfoResult(TGameInfo value) {
        this.gameInfoResult = value;
    }

}
