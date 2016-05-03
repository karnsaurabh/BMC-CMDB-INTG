package com.metricstream.itgrc.bmc.collections.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Named;

import com.metricstream.itgrc.atr.dao.vo.MsItgBmcAtrMapping;
import com.metricstream.itgrc.atr.dao.vo.MsItgBmcComputerSystem;
import com.metricstream.itgrc.cmd.asset.request.ASSTRelatedType;
import com.metricstream.itgrc.cmd.asset.request.ASSTType;
import com.metricstream.itgrc.cmd.asset.request.DataLinesType;
import com.metricstream.itgrc.cmd.asset.request.Datapacket;
import com.metricstream.itgrc.cmd.asset.request.MessageHeaderType;
import com.metricstream.itgrc.cmd.asset.request.RelationshipType;

@Named
public class CreateAssetPayloadTransformer {

    public Datapacket buildPayload(Object input, MsItgBmcAtrMapping msItgBmcAtrMapping, String ipv4Address, String ipv6Address, String macAddress) {
        Datapacket datapacket = new Datapacket();
        datapacket.setMessageHeader(getMessageHeader());
        datapacket.setDataLines(getDataLines(input, msItgBmcAtrMapping, ipv4Address, ipv6Address, macAddress));

        return datapacket;
    }
    private DataLinesType getDataLines(Object input, MsItgBmcAtrMapping msItgBmcAtrMapping, String ipv4Address, String ipv6Address, String macAddress) {
        DataLinesType dataLinesType = new DataLinesType();
        List<ASSTType> asstTypes = new ArrayList<ASSTType>();
        MsItgBmcComputerSystem msItgBmcComputerSystem = null;
        if (input instanceof MsItgBmcComputerSystem) {
            msItgBmcComputerSystem = MsItgBmcComputerSystem.class.cast(input);

            ASSTType asstType = new ASSTType();
            asstType.setDescription(msItgBmcComputerSystem.getDescription());
            asstType.setAssetObjectType("IP-Based");
            asstType.setDnsNameFqdn(msItgBmcComputerSystem.getDomain());
            asstType.setIpv4Address(ipv4Address);
            asstType.setIpv6Address(ipv6Address);
            asstType.setMacAddress(macAddress);
            asstType.setPhysicalLocation(msItgBmcComputerSystem.getSite() + "-" + msItgBmcComputerSystem.getFloor() + "-" + msItgBmcComputerSystem.getRegion() + "-" + msItgBmcComputerSystem.getRoom() + "-" + msItgBmcComputerSystem.getSiteGroup());
            asstType.setConfidentiality(msItgBmcComputerSystem.getConfidentiality());
            asstType.setIntegrity(msItgBmcComputerSystem.getIntegrity());
            asstType.setAvailability(msItgBmcComputerSystem.getAvailability());
            asstType.setOwners(msItgBmcComputerSystem.getOwnerName());
            asstType.setSerial(msItgBmcComputerSystem.getSerialNumber());
            asstType.setName(msItgBmcComputerSystem.getName());
            asstType.setOwnerOrganizations(msItgBmcComputerSystem.getDepartment());
            asstType.setObjectId(msItgBmcAtrMapping.getObjectId());
            RelationshipType relationshipType = new RelationshipType();
            ASSTRelatedType asstRelatedType = new ASSTRelatedType();
            asstRelatedType.setObjectName(msItgBmcComputerSystem.getPrimaryCapability().toString());
            relationshipType.getRelatedObjects().add(asstRelatedType);
            asstType.setRelationships(relationshipType);
            asstTypes.add(asstType);
            dataLinesType.getAsset().addAll(asstTypes);
        }
        return dataLinesType;
    }

    private MessageHeaderType getMessageHeader() {
        MessageHeaderType messageHeaderType = new MessageHeaderType();
        messageHeaderType.setCreateDateTime(new Date().toString());
        messageHeaderType.setObjectType("MS_ITG_CMD_ASSET");
        messageHeaderType.setOperation("CREATE");
        messageHeaderType.setPurpose("Testing");
        messageHeaderType.setRequestMessageId(UUID.randomUUID().toString());
        messageHeaderType.setVersion("1.0");
        messageHeaderType.setSource("ATR");

        return messageHeaderType;
    }

}
