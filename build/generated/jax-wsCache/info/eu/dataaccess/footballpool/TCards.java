
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tCards complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tCards">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iYellow" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="iRed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCards", propOrder = {
    "iYellow",
    "iRed"
})
public class TCards {

    protected int iYellow;
    protected int iRed;

    /**
     * Obtiene el valor de la propiedad iYellow.
     * 
     */
    public int getIYellow() {
        return iYellow;
    }

    /**
     * Define el valor de la propiedad iYellow.
     * 
     */
    public void setIYellow(int value) {
        this.iYellow = value;
    }

    /**
     * Obtiene el valor de la propiedad iRed.
     * 
     */
    public int getIRed() {
        return iRed;
    }

    /**
     * Define el valor de la propiedad iRed.
     * 
     */
    public void setIRed(int value) {
        this.iRed = value;
    }

}
