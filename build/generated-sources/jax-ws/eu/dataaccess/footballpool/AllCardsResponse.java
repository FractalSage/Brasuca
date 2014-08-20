
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
 *         &lt;element name="AllCardsResult" type="{http://footballpool.dataaccess.eu}ArrayOftCardInfo"/>
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
    "allCardsResult"
})
@XmlRootElement(name = "AllCardsResponse")
public class AllCardsResponse {

    @XmlElement(name = "AllCardsResult", required = true)
    protected ArrayOftCardInfo allCardsResult;

    /**
     * Obtiene el valor de la propiedad allCardsResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftCardInfo }
     *     
     */
    public ArrayOftCardInfo getAllCardsResult() {
        return allCardsResult;
    }

    /**
     * Define el valor de la propiedad allCardsResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftCardInfo }
     *     
     */
    public void setAllCardsResult(ArrayOftCardInfo value) {
        this.allCardsResult = value;
    }

}
