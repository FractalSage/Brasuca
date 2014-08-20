
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
 *         &lt;element name="TopSelectedGoalScorersResult" type="{http://footballpool.dataaccess.eu}ArrayOftTopSelectedGoalScorer"/>
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
    "topSelectedGoalScorersResult"
})
@XmlRootElement(name = "TopSelectedGoalScorersResponse")
public class TopSelectedGoalScorersResponse {

    @XmlElement(name = "TopSelectedGoalScorersResult", required = true)
    protected ArrayOftTopSelectedGoalScorer topSelectedGoalScorersResult;

    /**
     * Obtiene el valor de la propiedad topSelectedGoalScorersResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftTopSelectedGoalScorer }
     *     
     */
    public ArrayOftTopSelectedGoalScorer getTopSelectedGoalScorersResult() {
        return topSelectedGoalScorersResult;
    }

    /**
     * Define el valor de la propiedad topSelectedGoalScorersResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftTopSelectedGoalScorer }
     *     
     */
    public void setTopSelectedGoalScorersResult(ArrayOftTopSelectedGoalScorer value) {
        this.topSelectedGoalScorersResult = value;
    }

}
