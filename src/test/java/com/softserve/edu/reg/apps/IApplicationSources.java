package com.softserve.edu.reg.apps;

/**
 * Created by Demon on 30.10.2016.
 */
public interface IApplicationSources {

    String getBrowserName();

    String getDriverPath();

    long getImplicitTimeOut();

    long getExplicitTimeOut();

    String getLanguage();

    String getSearchStrategy();

    String getLoggerstrategy();

    String getLoginUrl();

    String getLogoutUrl();

    String serverUrl();
}
