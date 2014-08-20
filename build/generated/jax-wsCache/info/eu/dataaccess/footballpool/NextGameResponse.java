
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
 *         &lt;element name="NextGameResult" type="{http://footballpool.dataaccess.eu}tGameInfo"/>
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
    "nextGameResult"
})
@XmlRootElement(name = "NextGameResponse")
public class NextGameResponse {

    @XmlElement(name = "NextGameResult", required = true)
    protected TGameInfo nextGameResult;

    /**
     * Obtiene el valor de la propiedad nextGameResult.
     * 
     * @return
     *     possible object is
     *     {@link TGameInfo }
     *     
     */
    public TGameInfo getNextGameResult() {
        return nextGameResult;
    }

    /**
     * Define el valor de la propiedad nextGameResult.
     * 
     * @param value
     *     allowed object is
     *     {@link TGameInfo }
     *     
     */
    public void setNextGameResult(TGameInfo value) {
        this.nextGameResult = value;
    }

}
