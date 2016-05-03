package com.metricstream.itgrc.atr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.bmc.atrium._2009._01.common.InstanceInfoOut;
import com.bmc.atrium._2009._01.common.Value;
import com.metricstream.itgrc.atr.constants.WebServiceAttributes;
import com.metricstream.itgrc.atr.dao.vo.MsItgBmcAtrMapping;
import com.metricstream.itgrc.atr.dao.vo.MsItgBmcAvailabilityAttr;
import com.metricstream.itgrc.atr.dao.vo.MsItgBmcComputerSystem;
import com.metricstream.itgrc.atr.dao.vo.MsItgBmcConfidentialAttr;
import com.metricstream.itgrc.atr.dao.vo.MsItgBmcHostedAccessPoint;
import com.metricstream.itgrc.atr.dao.vo.MsItgBmcIntegrityAttr;
import com.metricstream.itgrc.atr.dao.vo.MsItgBmcIpEndpoint;
import com.metricstream.itgrc.atr.dao.vo.MsItgBmcLanEndpoint;
import com.metricstream.itgrc.bmc.utils.UniqueObjectIdUtil;
import com.metricstream.itgrc.core.annotation.DaoQualifier;
import com.metricstream.itgrc.core.constants.DaoQualifierType;
import com.metricstream.itgrc.core.dao.model.IDao;
import com.metricstream.itgrc.core.exceptions.AppException;
import com.metricstream.log.Logger;

@Named
public class PersistWebServiceClasses {

    @Inject
    @DaoQualifier(value = DaoQualifierType.DEFAULT)
    private IDao coreDAO;

    @Inject
    private UniqueObjectIdUtil uniqueObjectIdUtil;
    
    Map<Integer, String> confidentialityMap = new HashMap<Integer, String>();
    Map<Integer, String> integrityMap = new HashMap<Integer, String>();
    Map<Integer, String> availabilityMap = new HashMap<Integer, String>();
    Map<Integer,String> primaryCapabilityMap = new HashMap<Integer, String>();
    
    public void persistComputerSystemClass(InstanceInfoOut instanceInfoOut, Map<String, Value> attributeMap) throws AppException {
        
    	loadConfidentialityDisplayValueMap();
    	loadAvailabilityDisplayValueMap();
    	loadIntegrityDisplayValueMap();
    	loadPrimaryCapabilityMap();

        MsItgBmcComputerSystem msItgBmcComputerSystem = new MsItgBmcComputerSystem();
        msItgBmcComputerSystem.setClassName(instanceInfoOut.getClassNameId().getClassName());
        Integer confidentiality = (attributeMap.get("Confidentiality")!= null) ? attributeMap.get("Confidentiality").getEnumValue() : null;
        msItgBmcComputerSystem.setConfidentiality(confidentialityMap.get(confidentiality));
        msItgBmcComputerSystem.setDepartment(attributeMap.get("Department")!=null ? attributeMap.get("Department").getStringValue(): null);
        msItgBmcComputerSystem.setDescription(attributeMap.get("Description")!=null ? attributeMap.get("Description").getStringValue():null);
        msItgBmcComputerSystem.setDomain(attributeMap.get("Domain")!=null ? attributeMap.get("Domain").getStringValue():null);
        msItgBmcComputerSystem.setFloor(attributeMap.get("Floor")!=null ? attributeMap.get("Floor").getStringValue():null);
        msItgBmcComputerSystem.setInstanceId(instanceInfoOut.getInstanceId());
        Integer integrity = (attributeMap.get("Integrity")!= null) ? attributeMap.get("Integrity").getEnumValue() : null;
        msItgBmcComputerSystem.setIntegrity(integrityMap.get(integrity));
        Integer availability = (attributeMap.get("Availability")!= null) ? attributeMap.get("Availability").getEnumValue() : null;
        msItgBmcComputerSystem.setAvailability(availabilityMap.get(availability));
        msItgBmcComputerSystem.setName(attributeMap.get("Name")!=null ? attributeMap.get("Name").getStringValue():null);
        msItgBmcComputerSystem.setNamespaceName(instanceInfoOut.getClassNameId().getNamespaceName());
        msItgBmcComputerSystem.setOwnerName(attributeMap.get("OwnerName")!= null ? attributeMap.get("OwnerName").getStringValue():null);
        msItgBmcComputerSystem.setRegion(attributeMap.get("Region")!=null ?attributeMap.get("Region").getStringValue():null);
        msItgBmcComputerSystem.setRoom(attributeMap.get("Room")!= null ? attributeMap.get("Room").getStringValue() :null);
        msItgBmcComputerSystem.setSerialNumber(attributeMap.get("Serial Number")!=null ? attributeMap.get("Serial Number").getStringValue():null);
        msItgBmcComputerSystem.setSite(attributeMap.get("Site")!=null ? attributeMap.get("Site").getStringValue():null);
        msItgBmcComputerSystem.setSiteGroup(attributeMap.get("SiteGroup")!=null ? attributeMap.get("SiteGroup").getStringValue():null);
        Logger.error("PersistWebServiceClasses", "persistComputerSystemClass, PRIMARY CAPABILITY" +  attributeMap.get(WebServiceAttributes.PRIMARY_CAPABILITY), null);
        Integer primaryCapability = (attributeMap.get(WebServiceAttributes.PRIMARY_CAPABILITY)!=null) ? attributeMap.get(WebServiceAttributes.PRIMARY_CAPABILITY).getEnumValue() : null;
        msItgBmcComputerSystem.setPrimaryCapability(primaryCapabilityMap.get(primaryCapability));
        coreDAO.persist(msItgBmcComputerSystem);

        if ((coreDAO.findById(instanceInfoOut.getInstanceId(), MsItgBmcAtrMapping.class)) == null) {
            MsItgBmcAtrMapping msItgBmcAtrMapping = new MsItgBmcAtrMapping();
            msItgBmcAtrMapping.setInstanceId(instanceInfoOut.getInstanceId());
            msItgBmcAtrMapping.setObjectId(uniqueObjectIdUtil.getUniqueObjectId());
            coreDAO.persist(msItgBmcAtrMapping);
        }
    }

    private void loadConfidentialityDisplayValueMap() throws AppException {
		List<MsItgBmcConfidentialAttr> msItgBmcConfidentialAttrs = coreDAO.findAll(MsItgBmcConfidentialAttr.class);

		for (MsItgBmcConfidentialAttr msItgBmcConfidentialAttr : msItgBmcConfidentialAttrs) {
			confidentialityMap.put(msItgBmcConfidentialAttr.getConfidentialityStoredV(), msItgBmcConfidentialAttr.getConfidentialityDisplayedV());
		}

	}
    
    private void loadAvailabilityDisplayValueMap() throws AppException {
		List<MsItgBmcAvailabilityAttr> msBmcAvailabilityAttrs = coreDAO.findAll(MsItgBmcAvailabilityAttr.class);

		for (MsItgBmcAvailabilityAttr msItgBmcAvailabilityAttr : msBmcAvailabilityAttrs) {
			availabilityMap.put(msItgBmcAvailabilityAttr.getAvailabiltyStoredV(), msItgBmcAvailabilityAttr.getAvailabilityDisplayedV());
		}

	}
    
    private void loadIntegrityDisplayValueMap() throws AppException {
		List<MsItgBmcIntegrityAttr> msItgBmcIntegrityAttrs = coreDAO.findAll(MsItgBmcIntegrityAttr.class);

		for (MsItgBmcIntegrityAttr msItgBmcIntegrityAttr : msItgBmcIntegrityAttrs) {
			integrityMap.put(msItgBmcIntegrityAttr.getIntegrityStoredV(), msItgBmcIntegrityAttr.getIntegrityDisplayedV());
		}

	}
    
    private void loadPrimaryCapabilityMap() throws AppException {
    	primaryCapabilityMap.put(0, "Not Dedicated");
        primaryCapabilityMap.put(1,"Unknown");
        primaryCapabilityMap.put(2,"Other");
        primaryCapabilityMap.put(3,"Storage");
        primaryCapabilityMap.put(4,"Router");
        primaryCapabilityMap.put(5,"Switch");
        primaryCapabilityMap.put(6,"Layer 3 Switch");
        primaryCapabilityMap.put(7,"Central Office Switch");
        primaryCapabilityMap.put(8,"Hub");
        primaryCapabilityMap.put(9,"Access Server");
        primaryCapabilityMap.put(10,"Firewall");
        primaryCapabilityMap.put(11,"Print");
        primaryCapabilityMap.put(12,"I/O");
        primaryCapabilityMap.put(13,"Web Caching");
        primaryCapabilityMap.put(14,"Server");
        primaryCapabilityMap.put(15,"Management");
        primaryCapabilityMap.put(16,"Block Server");
        primaryCapabilityMap.put(17,"File Server");
        primaryCapabilityMap.put(18,"Mobile User Device");
        primaryCapabilityMap.put(19,"Repeater");
        primaryCapabilityMap.put(20,"Bridge/Extender");
        primaryCapabilityMap.put(21,"Gateway");
        primaryCapabilityMap.put(22,"LoadBalancer");
        primaryCapabilityMap.put(23,"Mainframe");
        primaryCapabilityMap.put(24,"SANSwitch");
        primaryCapabilityMap.put(25,"SANHub");
        primaryCapabilityMap.put(26,"SANBridge");
        primaryCapabilityMap.put(27,"SANRouter");
        primaryCapabilityMap.put(28,"SANDirector");
        primaryCapabilityMap.put(29,"RAIDStorageDevice");
        primaryCapabilityMap.put(30,"Virtual Tape Library");
        primaryCapabilityMap.put(31,"JBOD");
        primaryCapabilityMap.put(32,"Workstation");
        primaryCapabilityMap.put(33,"StorageSubsystem");
        primaryCapabilityMap.put(34,"Storage Virtualizer");
        primaryCapabilityMap.put(35,"Media Library");
        primaryCapabilityMap.put(36,"ExtenderNode");
        primaryCapabilityMap.put(37,"NAS Head");
        primaryCapabilityMap.put(38,"Self-contained NAS");
        primaryCapabilityMap.put(39,"UPS");
        primaryCapabilityMap.put(40,"IP Phone");
        primaryCapabilityMap.put(41,"Management Controller");
        primaryCapabilityMap.put(42,"Chassis Manager");
        primaryCapabilityMap.put(43,"Host-based RAID controller");
        primaryCapabilityMap.put(44,"Storage Device Enclosure");
        primaryCapabilityMap.put(45,"Desktop");
        primaryCapabilityMap.put(46,"Laptop");
        primaryCapabilityMap.put(47,"Virtual Library System");
        primaryCapabilityMap.put(48,"Blade System");
        primaryCapabilityMap.put(49,"Blade Server");
        primaryCapabilityMap.put(50,"VPN Concentrator");
        primaryCapabilityMap.put(51,"Proxy Server");
        primaryCapabilityMap.put(52,"Layer 3 Proxy Server");
        primaryCapabilityMap.put(53,"WAN Accelerator");
        primaryCapabilityMap.put(54,"SAN Processor");
	}
    public void persistLanEndPointClass(InstanceInfoOut instanceInfoOut, Map<String, String> attributeMap) throws AppException {
        MsItgBmcLanEndpoint msItgBmcLanEndpoint = new MsItgBmcLanEndpoint();
        msItgBmcLanEndpoint.setClassName(instanceInfoOut.getClassNameId().getClassName());
        msItgBmcLanEndpoint.setMacaddress(attributeMap.get("MACAddress"));
        msItgBmcLanEndpoint.setInstanceId(instanceInfoOut.getInstanceId());
        msItgBmcLanEndpoint.setNamespaceName(instanceInfoOut.getClassNameId().getNamespaceName());
        coreDAO.persist(msItgBmcLanEndpoint);

    }

    public void persistIPEndpointClass(InstanceInfoOut instanceInfoOut, Map<String, String> attributeMap) throws AppException {
        MsItgBmcIpEndpoint msItgBmcIpEndpoint = new MsItgBmcIpEndpoint();
        msItgBmcIpEndpoint.setClassName(instanceInfoOut.getClassNameId().getClassName());
        msItgBmcIpEndpoint.setAddressType(attributeMap.get("AddressType"));
        msItgBmcIpEndpoint.setInstanceId(instanceInfoOut.getInstanceId());
        msItgBmcIpEndpoint.setNamespaceName(instanceInfoOut.getClassNameId().getNamespaceName());
        msItgBmcIpEndpoint.setAddress(attributeMap.get("Address"));
        msItgBmcIpEndpoint.setDnsHostname(attributeMap.get("DNSHostName"));
        coreDAO.persist(msItgBmcIpEndpoint);

    }

    public void persistHostedAccessPointClass(InstanceInfoOut instanceInfoOut, Map<String, String> attributeMap) throws AppException {
        MsItgBmcHostedAccessPoint msItgBmcHostedAccessPoint = new MsItgBmcHostedAccessPoint();
        msItgBmcHostedAccessPoint.setClassName(instanceInfoOut.getClassNameId().getClassName());
        msItgBmcHostedAccessPoint.setDestinationInstanceId(attributeMap.get("Destination.InstanceId"));
        msItgBmcHostedAccessPoint.setInstanceId(instanceInfoOut.getInstanceId());
        msItgBmcHostedAccessPoint.setName(attributeMap.get("Name"));
        msItgBmcHostedAccessPoint.setNamespaceName(instanceInfoOut.getClassNameId().getNamespaceName());
        msItgBmcHostedAccessPoint.setSourceInstanceId(attributeMap.get("Source.InstanceId"));
        coreDAO.persist(msItgBmcHostedAccessPoint);

    }
}
