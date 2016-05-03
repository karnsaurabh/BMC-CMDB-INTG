package com.metricstream.itgrc.atr.service;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.metricstream.itgrc.atr.constants.ConfigKey;
import com.metricstream.itgrc.atr.constants.TransactionManager;
import com.metricstream.itgrc.atr.dao.vo.MsItgAtrConfigV;
import com.metricstream.itgrc.core.annotation.DaoQualifier;
import com.metricstream.itgrc.core.aspect.Loggable;
import com.metricstream.itgrc.core.constants.DaoQualifierType;
import com.metricstream.itgrc.core.dao.model.IDao;
import com.metricstream.itgrc.core.exceptions.AppException;
import com.metricstream.itgrc.core.service.ConfigRepository;
import com.metricstream.itgrc.core.utils.EncryptionUtilities;

/**
 * Module: ITGRC <br>
 * 
 * The class ConfigRmdPushInfoletImplN stores the webservices config information into the ITG CONFIG table.
 * 
 * @author arjun.tomer
 * 
 */
@Named
@Transactional(value = TransactionManager.TRANSACTION_MANAGER, rollbackFor = Exception.class)
public class ConfigAtrPushInfoletImplN {

    /** The config repository. */
    @Inject
    private ConfigRepository configRepository;

    /** The core dao. */
    @Inject
    @DaoQualifier(value = DaoQualifierType.DEFAULT)
    private IDao coreDao;

    /**
     * Run.
     * 
     * @param processInstanceId
     *            the process instance id
     * @throws AppException
     *             the application exception
     */
    @Loggable
    public void run(double processInstanceId) throws AppException {
        MsItgAtrConfigV msItgAtrConfigV = coreDao.findById(BigDecimal.valueOf(new Double(processInstanceId)), MsItgAtrConfigV.class);
        configRepository.setConfig(ConfigKey.ATRIUM_SERVER_URL, msItgAtrConfigV.getArServerUrl());
        configRepository.setConfig(ConfigKey.ATRIUM_USER_NAME, EncryptionUtilities.encrypt(msItgAtrConfigV.getUsername()));
        configRepository.setConfig(ConfigKey.ATRIUM_PASSWORD, EncryptionUtilities.encrypt(msItgAtrConfigV.getServerPassword()));

        msItgAtrConfigV.setUsername(null);
        msItgAtrConfigV.setServerPassword(null);
    }
}
