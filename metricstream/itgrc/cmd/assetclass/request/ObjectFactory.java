//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.20 at 02:46:29 PM IST 
//


package com.metricstream.itgrc.cmd.assetclass.request;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.metricstream.itgrc.cmd.assetclass.request package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.metricstream.itgrc.cmd.assetclass.request
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Datapacket }
     * 
     */
    public Datapacket createDatapacket() {
        return new Datapacket();
    }

    /**
     * Create an instance of {@link MessageHeaderType }
     * 
     */
    public MessageHeaderType createMessageHeaderType() {
        return new MessageHeaderType();
    }

    /**
     * Create an instance of {@link DataLinesType }
     * 
     */
    public DataLinesType createDataLinesType() {
        return new DataLinesType();
    }

    /**
     * Create an instance of {@link RelatedType }
     * 
     */
    public RelatedType createRelatedType() {
        return new RelatedType();
    }

    /**
     * Create an instance of {@link ASCLType }
     * 
     */
    public ASCLType createASCLType() {
        return new ASCLType();
    }

    /**
     * Create an instance of {@link ListOfValues }
     * 
     */
    public ListOfValues createListOfValues() {
        return new ListOfValues();
    }

    /**
     * Create an instance of {@link CommonFieldsType }
     * 
     */
    public CommonFieldsType createCommonFieldsType() {
        return new CommonFieldsType();
    }

}
