
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="DateOfFirstGameResult" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
    "dateOfFirstGameResult"
})
@XmlRootElement(name = "DateOfFirstGameResponse")
public class DateOfFirstGameResponse {

    @XmlElement(name = "DateOfFirstGameResult", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfFirstGameResult;

    /**
     * Obtiene el valor de la propiedad dateOfFirstGameResult.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfFirstGameResult() {
        return dateOfFirstGameResult;
    }

    /**
     * Define el valor de la propiedad dateOfFirstGameResult.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfFirstGameResult(XMLGregorianCalendar value) {
        this.dateOfFirstGameResult = value;
    }

}
