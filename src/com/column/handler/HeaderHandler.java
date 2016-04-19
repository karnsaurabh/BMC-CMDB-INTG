/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.column.handler;

import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.column.util.UserCred;

/**
 *
 * @author ygaikwad
 */
public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {

    private static final String SECURITY_NAME_SPACE = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
    private static final String SECURITY_PERFIX = "wsse";
    private static final String SECURITY_LOCALPART_SECURITY = "Security";
    private static final String SECURITY_LOCALPART_USERNAME_TOKEN = "UsernameToken";
    private static final String SECURITY_LOCALPART_USERNAME = "Username";
    private static final String SECURITY_LOCALPART_PASSWORD = "Password";

    @Override
    public Set<QName> getHeaders() {
//        throw new UnsupportedOperationException("Not supported yet.");
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext smc) {
//        throw new UnsupportedOperationException("Not supported yet.");
        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        UserCred uc = UserCred.getUserCred();
        
        if (outboundProperty.booleanValue()) {

            SOAPMessage message = smc.getMessage();

            try {

                SOAPEnvelope envelope = smc.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.addHeader();

                SOAPElement security = header.addChildElement(SECURITY_LOCALPART_SECURITY, SECURITY_PERFIX, SECURITY_NAME_SPACE);

                SOAPElement usernameToken = security.addChildElement(SECURITY_LOCALPART_USERNAME_TOKEN, SECURITY_PERFIX);
                usernameToken.addAttribute(new QName(SECURITY_NAME_SPACE,SECURITY_LOCALPART_USERNAME_TOKEN, SECURITY_PERFIX), null);

                SOAPElement username = usernameToken.addChildElement(SECURITY_LOCALPART_USERNAME, SECURITY_PERFIX);
                username.addTextNode(uc.getUserName());

                SOAPElement password = usernameToken.addChildElement(SECURITY_LOCALPART_PASSWORD, SECURITY_PERFIX);
//                password.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
                password.addTextNode(uc.getPwd());

                //Print out the outbound SOAP message to System.out
                message.writeTo(System.out);
                System.out.println("");

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            try {

                //This handler does nothing with the response from the Web Service so
                //we just print out the SOAP message.
                SOAPMessage message = smc.getMessage();
                message.writeTo(System.out);
                System.out.println("");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


        return outboundProperty;


    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
//        throw new UnsupportedOperationException("Not supported yet.");
        return true;

    }

    @Override
    public void close(MessageContext context) {
    }
}
