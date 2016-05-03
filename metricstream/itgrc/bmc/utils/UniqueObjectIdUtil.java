package com.metricstream.itgrc.bmc.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.inject.Inject;
import javax.inject.Named;

import com.metricstream.itgrc.core.service.ConnectionProviderImpl;
import com.metricstream.log.Logger;

@Named
public class UniqueObjectIdUtil {
    
    @Inject
    private ConnectionProviderImpl connectionProviderImpl;
    
    public String getUniqueObjectId() {
        Connection con = null;
        try {
            con = connectionProviderImpl.getConnection();

            CallableStatement stmt;

            stmt = con.prepareCall("{? = call MS_ATR_OBJECT_ID_GEN}");
            stmt.registerOutParameter(1, Types.VARCHAR);
            stmt.executeUpdate();
            String objectId = stmt.getString(1);
            return objectId;

        } catch (SQLException e) {
            Logger.error("Create CMDBOBJECT", "getUniqueObjectId" + e, null);
        } finally {
            try {
                connectionProviderImpl.closeConnection(con);
            } catch (SQLException e) {
                Logger.error("Create CMDBOBJECT", "getUniqueObjectId" + e, null);
            }
        }
        return null;

    }

}
