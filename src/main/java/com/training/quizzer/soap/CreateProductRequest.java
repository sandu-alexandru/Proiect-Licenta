//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.29 at 09:11:55 PM EEST 
//


package com.training.quizzer.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="warehouseId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="producerId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "productName",
    "warehouseId",
    "producerId",
    "quantity"
})
@XmlRootElement(name = "createProductRequest")
public class CreateProductRequest {

    @XmlElement(required = true)
    protected String productName;
    protected long warehouseId;
    protected long producerId;
    protected long quantity;

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the warehouseId property.
     * 
     */
    public long getWarehouseId() {
        return warehouseId;
    }

    /**
     * Sets the value of the warehouseId property.
     * 
     */
    public void setWarehouseId(long value) {
        this.warehouseId = value;
    }

    /**
     * Gets the value of the producerId property.
     * 
     */
    public long getProducerId() {
        return producerId;
    }

    /**
     * Sets the value of the producerId property.
     * 
     */
    public void setProducerId(long value) {
        this.producerId = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     */
    public long getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(long value) {
        this.quantity = value;
    }

}