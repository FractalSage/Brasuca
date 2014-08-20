
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
 *         &lt;element name="SignupsPerDateResult" type="{http://footballpool.dataaccess.eu}ArrayOftSignupCount"/>
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
    "signupsPerDateResult"
})
@XmlRootElement(name = "SignupsPerDateResponse")
public class SignupsPerDateResponse {

    @XmlElement(name = "SignupsPerDateResult", required = true)
    protected ArrayOftSignupCount signupsPerDateResult;

    /**
     * Obtiene el valor de la propiedad signupsPerDateResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftSignupCount }
     *     
     */
    public ArrayOftSignupCount getSignupsPerDateResult() {
        return signupsPerDateResult;
    }

    /**
     * Define el valor de la propiedad signupsPerDateResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftSignupCount }
     *     
     */
    public void setSignupsPerDateResult(ArrayOftSignupCount value) {
        this.signupsPerDateResult = value;
    }

}
