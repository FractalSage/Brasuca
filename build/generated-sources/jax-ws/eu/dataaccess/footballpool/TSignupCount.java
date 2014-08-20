
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para tSignupCount complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tSignupCount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dSignup" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="iCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="iTotal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="iAverage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSignupCount", propOrder = {
    "dSignup",
    "iCount",
    "iTotal",
    "iAverage"
})
public class TSignupCount {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dSignup;
    protected int iCount;
    protected int iTotal;
    protected int iAverage;

    /**
     * Obtiene el valor de la propiedad dSignup.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDSignup() {
        return dSignup;
    }

    /**
     * Define el valor de la propiedad dSignup.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDSignup(XMLGregorianCalendar value) {
        this.dSignup = value;
    }

    /**
     * Obtiene el valor de la propiedad iCount.
     * 
     */
    public int getICount() {
        return iCount;
    }

    /**
     * Define el valor de la propiedad iCount.
     * 
     */
    public void setICount(int value) {
        this.iCount = value;
    }

    /**
     * Obtiene el valor de la propiedad iTotal.
     * 
     */
    public int getITotal() {
        return iTotal;
    }

    /**
     * Define el valor de la propiedad iTotal.
     * 
     */
    public void setITotal(int value) {
        this.iTotal = value;
    }

    /**
     * Obtiene el valor de la propiedad iAverage.
     * 
     */
    public int getIAverage() {
        return iAverage;
    }

    /**
     * Define el valor de la propiedad iAverage.
     * 
     */
    public void setIAverage(int value) {
        this.iAverage = value;
    }

}
