package com.metricstream.itgrc.atr.service;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.validator.routines.InetAddressValidator;

import com.metricstream.appstudio.cif.Message;
import com.metricstream.appstudio.cif.Response;
import com.metricstream.appstudio.cif.UserContext;
import com.metricstream.appstudio.cif.UserContext.Builder;
import com.metricstream.appstudio.cif.exceptions.CifException;
import com.metricstream.itgrc.atr.constants.CifServiceName;
import com.metricstream.itgrc.atr.dao.home.MsItgAtrDaoHome;
import com.metricstream.itgrc.atr.dao.vo.MsItgBmcAtrMapping;
import com.metricstream.itgrc.atr.dao.vo.MsItgBmcComputerSystem;
import com.metricstream.itgrc.atr.dao.vo.MsItgBmcHostedAccessPoint;
import com.metricstream.itgrc.atr.dao.vo.MsItgBmcIpEndpoint;
import com.metricstream.itgrc.atr.dao.vo.MsItgBmcLanEndpoint;
import com.metricstream.itgrc.bmc.collections.impl.CreateAssetPayloadTransformer;
import com.metricstream.itgrc.cmd.asset.request.Datapacket;
import com.metricstream.itgrc.core.annotation.DaoQualifier;
import com.metricstream.itgrc.core.builder.CoreJAXBDocumentBuilder;
import com.metricstream.itgrc.core.constants.DaoQualifierType;
import com.metricstream.itgrc.core.dao.model.IDao;
import com.metricstream.itgrc.core.exceptions.AppException;
import com.metricstream.log.Logger;

@Named
public class BMCCreateAssetConsumer {

    @Inject
    @DaoQualifier(value = DaoQualifierType.DEFAULT)
    private IDao coreDao;

    @Inject
    private CreateAssetPayloadTransformer createAssetPayloadTransformer;

    @Inject
    private CoreJAXBDocumentBuilder builder;

    @Inject
    private MsItgAtrDaoHome msItgAtrDaoHome;

    public void call() throws AppException, UnknownHostException {
        List<MsItgBmcComputerSystem> msItgBmcComputerSystems = coreDao.findAll(MsItgBmcComputerSystem.class);
        Logger.error("BMCCreateAssetConsumer", "inside call method[10000] ComputerSystem List Size: " + msItgBmcComputerSystems.size(), null);
        for (MsItgBmcComputerSystem msItgBmcComputerSystem : msItgBmcComputerSystems) {
            Logger.error("BMCCreateAssetConsumer", "inside call method[9999] ComputerSystem InstanceId: " + msItgBmcComputerSystem.getInstanceId(), null);
            String requestXml = null;
            List<MsItgBmcHostedAccessPoint> msItgBmcHostedAccessPoints = msItgAtrDaoHome.getHostedAccessData(MsItgBmcHostedAccessPoint.class, msItgBmcComputerSystem.getInstanceId());
            Logger.error("BMCCreateAssetConsumer", "inside call method[9998] HostedAccessPoint size: " + msItgBmcHostedAccessPoints.size(), null);
            String ipv4Address = null;
            String ipv6Address = null;
            String macAddress = null;
            for (MsItgBmcHostedAccessPoint msItgBmcHostedAccessPoint : msItgBmcHostedAccessPoints) {
                Logger.error("BMCCreateAssetConsumer", "inside call method[9997] HostedAccessPoint Destination Instance Id: " + msItgBmcHostedAccessPoint.getDestinationInstanceId(), null);
                if (ipv4Address != null && ipv6Address != null) {
                    break;
                }
                List<MsItgBmcIpEndpoint> msItgBmcIpEndpoints = msItgAtrDaoHome.getIPAddressData(MsItgBmcIpEndpoint.class, msItgBmcHostedAccessPoint.getDestinationInstanceId());
                Logger.error("BMCCreateAssetConsumer", "inside call method[9996] IPENDPOINT SIZE: " + msItgBmcIpEndpoints.size(), null);
                for(MsItgBmcIpEndpoint msItgBmcIpEndpoint: msItgBmcIpEndpoints){
                    Logger.error("BMCCreateAssetConsumer", "inside call method[9995] ADDRESS: " + msItgBmcIpEndpoint.getAddress(), null);
                if (InetAddressValidator.getInstance().isValidInet4Address(msItgBmcIpEndpoint.getAddress())) {
                    Logger.error("BMCCreateAssetConsumer", "inside call method[9994] INSIDE IPV4: " + msItgBmcIpEndpoint.getAddress(), null);
                    ipv4Address = msItgBmcIpEndpoint.getAddress();
                } else if (InetAddress.getByName(msItgBmcIpEndpoint.getAddress()) instanceof Inet6Address) {
                    Logger.error("BMCCreateAssetConsumer", "inside call method[9993] INSIDE IPV6: " + msItgBmcIpEndpoint.getAddress(), null);
                    ipv6Address = msItgBmcIpEndpoint.getAddress();
                }
                }

                List<MsItgBmcLanEndpoint> msItgBmcLanEndpoints = msItgAtrDaoHome.getLanAddressData(MsItgBmcLanEndpoint.class, msItgBmcHostedAccessPoint.getDestinationInstanceId());
                Logger.error("BMCCreateAssetConsumer", "inside call method[9992] SIZE: " + msItgBmcLanEndpoints.size(), null);
                for(MsItgBmcLanEndpoint msItgBmcLanEndpoint: msItgBmcLanEndpoints){
                    Logger.error("BMCCreateAssetConsumer", "inside call method[9991] MACADDRESS: " + msItgBmcLanEndpoint.getMacaddress(), null);
                    macAddress = msItgBmcLanEndpoint.getMacaddress();   
                }
                 

            }

            MsItgBmcAtrMapping msItgBmcAtrMapping = coreDao.findById(msItgBmcComputerSystem.getInstanceId(), MsItgBmcAtrMapping.class);
            Logger.error("BMCCreateAssetConsumer", "inside call method[9991] JUST BEFORE BUILD PAYLOAD: " + macAddress + "ipv4 Address" + ipv4Address + "ipv6address" + ipv6Address, null);
            Datapacket datapacket = createAssetPayloadTransformer.buildPayload(msItgBmcComputerSystem, msItgBmcAtrMapping,ipv4Address,ipv6Address,macAddress);
            requestXml = builder.create(datapacket, Datapacket.class);
            buildMessageAndSendMethod(CifServiceName.MS_CMD_CREATE_OBJECT, requestXml);

        }

    }
    private void buildMessageAndSendMethod(String endPoint, String payload) throws AppException {

        Message message = new Message.Builder().toEndPoint(endPoint).setBody(payload).userContext(getCifUserContext()).setSuccessCallBackClass(SuccessErrorCallBack.class).setErrorCallBackClass(SuccessErrorCallBack.class).build();

        try {
            Response response = message.send();
        } catch (CifException e) {
            throw new AppException(e);
        }

    }

    private UserContext getCifUserContext() {
        Builder builder = new UserContext.Builder().userId(100000l);
        return builder.build();
    }
}
