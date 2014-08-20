
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
 *         &lt;element name="DateLastGroupGameResult" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
    "dateLastGroupGameResult"
})
@XmlRootElement(name = "DateLastGroupGameResponse")
public class DateLastGroupGameResponse {

    @XmlElement(name = "DateLastGroupGameResult", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateLastGroupGameResult;

    /**
     * Obtiene el valor de la propiedad dateLastGroupGameResult.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateLastGroupGameResult() {
        return dateLastGroupGameResult;
    }

    /**
     * Define el valor de la propiedad dateLastGroupGameResult.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateLastGroupGameResult(XMLGregorianCalendar value) {
        this.dateLastGroupGameResult = value;
    }

}
