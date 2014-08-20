
package eu.dataaccess.footballpool;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="bSortedByName" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bSortedByYellowCards" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "bSortedByName",
    "bSortedByYellowCards"
})
@XmlRootElement(name = "AllPlayersWithYellowCards")
public class AllPlayersWithYellowCards {

    protected boolean bSortedByName;
    protected boolean bSortedByYellowCards;

    /**
     * Obtiene el valor de la propiedad bSortedByName.
     * 
     */
    public boolean isBSortedByName() {
        return bSortedByName;
    }

    /**
     * Define el valor de la propiedad bSortedByName.
     * 
     */
    public void setBSortedByName(boolean value) {
        this.bSortedByName = value;
    }

    /**
     * Obtiene el valor de la propiedad bSortedByYellowCards.
     * 
     */
    public boolean isBSortedByYellowCards() {
        return bSortedByYellowCards;
    }

    /**
     * Define el valor de la propiedad bSortedByYellowCards.
     * 
     */
    public void setBSortedByYellowCards(boolean value) {
        this.bSortedByYellowCards = value;
    }

}
