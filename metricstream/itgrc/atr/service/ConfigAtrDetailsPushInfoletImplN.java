package com.metricstream.itgrc.atr.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.metricstream.itgrc.atr.constants.ConfigKey;
import com.metricstream.itgrc.atr.constants.TransactionManager;
import com.metricstream.itgrc.core.aspect.Loggable;
import com.metricstream.itgrc.core.exceptions.AppException;
import com.metricstream.itgrc.core.service.ConfigRepository;
import com.metricstream.itgrc.core.utils.EncryptionUtilities;

/**
 * Module: ITGRC <br>
 * 
 * The class ConfigDetailsPushformInfoletImplN fetches configuration values from ms_itg_config table.
 * 
 * @author arjun.tomer
 * 
 */
@Named
@Transactional(value = TransactionManager.TRANSACTION_MANAGER, rollbackFor = Exception.class)
public class ConfigAtrDetailsPushInfoletImplN {

    /** The config repository. */
    @Inject
    private ConfigRepository configRepository;

    /** Spring based constants. */
    @SuppressWarnings("unused")
    private String atriumServerUrl;

    /** The api username. */
    @SuppressWarnings("unused")
    private String serverUsername;

    /** The api password. */
    @SuppressWarnings("unused")
    private String serverPassword;

    /**
     * Load constants.
     * 
     * @throws AppException
     *             the application exception
     */
    public void loadConstants() throws AppException {
        atriumServerUrl = configRepository.getConfigValue(ConfigKey.ATRIUM_SERVER_URL);
        serverUsername = configRepository.getConfigValue(ConfigKey.ATRIUM_USER_NAME);
        serverPassword = configRepository.getConfigValue(ConfigKey.ATRIUM_PASSWORD);
    }

    /**
     * Configuration values base api Url,rest api Username,rest api Password are fetched. rest api Username and rest api
     * Password are decrypted.
     * 
     * @return String[][], return the configuration data
     * @throws AppException
     *             the application exception
     */

    @Loggable
    public String[][] fetchConfigurationInfo() throws AppException {
        loadConstants();
        String[][] data = new String[1][3];
        data[0][0] = configRepository.getConfigValue(ConfigKey.ATRIUM_SERVER_URL);
        data[0][1] = EncryptionUtilities.decrypt(configRepository.getConfigValue(ConfigKey.ATRIUM_USER_NAME));
        data[0][2] = EncryptionUtilities.decrypt(configRepository.getConfigValue(ConfigKey.ATRIUM_PASSWORD));

        return data;
    }
}
