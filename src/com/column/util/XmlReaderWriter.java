package com.column.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.column.model.CMDB;
import com.column.model.output.CMDBOutputData;


public class XmlReaderWriter {
//	private static final String XMLFILEPATH_INPUT="xml_resources\\inputXml.xml";
	private static Logger logger = Logger.getLogger(XmlReaderWriter.class);
	public static CMDB getIndataObject(String xmlFilePath){
		CMDB cmdb = null ;		
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(CMDB.class);
			Unmarshaller um = context.createUnmarshaller();
			cmdb = (CMDB) um.unmarshal(new FileReader(xmlFilePath));
			
		} catch (JAXBException e) {

			e.printStackTrace();
			logger.debug("JAXBException : ", e);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			logger.debug("FileNotFoundException : ", e);
		}catch(Exception e){

			logger.error("Other Exception ", e);
		}
		return cmdb;
	}
	
public static void writeOutputData(String xmlFilePath, CMDBOutputData outData, String fileName){
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(CMDBOutputData.class);
			Marshaller m = context.createMarshaller();
		    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);			
		    m.marshal(outData, new File(xmlFilePath+fileName+".xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
			logger.debug("JAXBException : ", e);
		} 
		catch (Exception e) {
			logger.error("Other Exception ", e);
		}
	}
}
