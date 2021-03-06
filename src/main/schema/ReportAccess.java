//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.08 at 11:03:57 AM CEST 
//


package com.adobe.analytics.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for report_access complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="report_access">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="category" type="{http://marketing.adobe.com/analytics/2015/04/16}report_access_category_enum"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="access" type="{http://marketing.adobe.com/analytics/2015/04/16}report_access_type_enum"/>
 *         &lt;element name="report_ids" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "report_access", propOrder = {

})
public class ReportAccess {

    @XmlElement(required = true)
    protected ReportAccessCategoryEnum category;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected ReportAccessTypeEnum access;
    @XmlElement(name = "report_ids", type = Integer.class)
    protected List<Integer> reportIds;

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link ReportAccessCategoryEnum }
     *     
     */
    public ReportAccessCategoryEnum getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportAccessCategoryEnum }
     *     
     */
    public void setCategory(ReportAccessCategoryEnum value) {
        this.category = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the access property.
     * 
     * @return
     *     possible object is
     *     {@link ReportAccessTypeEnum }
     *     
     */
    public ReportAccessTypeEnum getAccess() {
        return access;
    }

    /**
     * Sets the value of the access property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportAccessTypeEnum }
     *     
     */
    public void setAccess(ReportAccessTypeEnum value) {
        this.access = value;
    }

    /**
     * Gets the value of the reportIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reportIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReportIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getReportIds() {
        if (reportIds == null) {
            reportIds = new ArrayList<Integer>();
        }
        return this.reportIds;
    }

}
