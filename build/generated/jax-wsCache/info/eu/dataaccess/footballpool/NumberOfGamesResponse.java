
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
 *         &lt;element name="NumberOfGamesResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "numberOfGamesResult"
})
@XmlRootElement(name = "NumberOfGamesResponse")
public class NumberOfGamesResponse {

    @XmlElement(name = "NumberOfGamesResult")
    protected int numberOfGamesResult;

    /**
     * Obtiene el valor de la propiedad numberOfGamesResult.
     * 
     */
    public int getNumberOfGamesResult() {
        return numberOfGamesResult;
    }

    /**
     * Define el valor de la propiedad numberOfGamesResult.
     * 
     */
    public void setNumberOfGamesResult(int value) {
        this.numberOfGamesResult = value;
    }

}
