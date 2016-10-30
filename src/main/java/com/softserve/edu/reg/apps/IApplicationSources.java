package com.softserve.edu.reg.apps;

/**
 * Created by Demon on 30.10.2016.
 */
public interface IApplicationSources {

    String getBrowserName();

    String getDriverPath();

    long getImplicitTimeOut();

    String getLoginUrl();

    String getLogoutUrl();
}
