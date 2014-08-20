
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
 *         &lt;element name="YellowCardsTotalResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "yellowCardsTotalResult"
})
@XmlRootElement(name = "YellowCardsTotalResponse")
public class YellowCardsTotalResponse {

    @XmlElement(name = "YellowCardsTotalResult")
    protected int yellowCardsTotalResult;

    /**
     * Obtiene el valor de la propiedad yellowCardsTotalResult.
     * 
     */
    public int getYellowCardsTotalResult() {
        return yellowCardsTotalResult;
    }

    /**
     * Define el valor de la propiedad yellowCardsTotalResult.
     * 
     */
    public void setYellowCardsTotalResult(int value) {
        this.yellowCardsTotalResult = value;
    }

}
