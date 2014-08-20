
package eu.dataaccess.footballpool;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOftGameCard complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOftGameCard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tGameCard" type="{http://footballpool.dataaccess.eu}tGameCard" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOftGameCard", propOrder = {
    "tGameCard"
})
public class ArrayOftGameCard {

    @XmlElement(nillable = true)
    protected List<TGameCard> tGameCard;

    /**
     * Gets the value of the tGameCard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tGameCard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTGameCard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TGameCard }
     * 
     * 
     */
    public List<TGameCard> getTGameCard() {
        if (tGameCard == null) {
            tGameCard = new ArrayList<TGameCard>();
        }
        return this.tGameCard;
    }

}
