//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.29 at 09:11:55 PM EEST 
//


package com.training.quizzer.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="warehouseId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="newLocationId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "warehouseId",
    "newLocationId"
})
@XmlRootElement(name = "changeWarehouseLocationRequest")
public class ChangeWarehouseLocationRequest {

    protected long warehouseId;
    protected long newLocationId;

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
     * Gets the value of the newLocationId property.
     * 
     */
    public long getNewLocationId() {
        return newLocationId;
    }

    /**
     * Sets the value of the newLocationId property.
     * 
     */
    public void setNewLocationId(long value) {
        this.newLocationId = value;
    }

}
