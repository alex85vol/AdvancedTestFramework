package com.softserve.edu.reg.apps;

interface IBrowserName {
    IDriverPath setBrowserName(String browserName);
}

interface IDriverPath {
    IBrowserPath setDriverPath(String driverPath);
}

interface IBrowserPath {
    IDefaultProfile setBrowserPath(String browserPath);
}

interface IDefaultProfile {
    IImplicitTimeOut setDefaultProfile(String defaultProfile);
}


interface IImplicitTimeOut {
    IExplicitTimeOut setImplicitTimeOut(long implicitTimeOut);
}

interface IExplicitTimeOut {
    ILanguage setExplicitTimeOut(long explicitTimeOut);
}

interface ILanguage {
    ISearchStrategy setLanguage(String language);
}

interface ISearchStrategy {
    ILoggerStrategy setSearchStrategy(String searchStrategy);
}

interface ILoggerStrategy {
    ILoginUrl setLoggerStrategy(String loggerStrategy);
}

interface ILoginUrl {
    ILogoutUrl setLoginUrl(String loginUrl);
}

interface ILogoutUrl {
    IServerUrl setLogoutUrl(String logoutUrl);
}

interface IServerUrl {
    IBuild setServerUrl(String serverUrl);
}

interface IBuild {
    ApplicationSources build();
}

public class ApplicationSources implements IBrowserName, IDriverPath,
        IBrowserPath, IDefaultProfile,
        IImplicitTimeOut, IExplicitTimeOut, ILanguage, ISearchStrategy,
        ILoggerStrategy, ILoginUrl, ILogoutUrl, IServerUrl,
        IBuild, IApplicationSources {


    // Browser Data
    private String browserName;
    private String driverPath;
    private String browserPath;
    private String defaultProfile;
    // Implicit and Explicit Waits
    private long implicitTimeOut;
    private long explicitTimeOut;
    // Localization Strategy
    private String language;
    // Search Strategy
    private String searchStrategy;
    // Logger Strategy
    private String loggerStrategy;
    // URLs
    private String loginUrl;
    private String logoutUrl;
    private String serverUrl;
    // Connect to DB

    private ApplicationSources() {
    }

    public static IBrowserName get() {
        return new ApplicationSources();
    }

    //setters
    public IDriverPath setBrowserName(String browserName) {
        this.browserName = browserName;
        return this;
    }

    public IBrowserPath setDriverPath(String driverPath) {
        this.driverPath = driverPath;
        return this;

    }

    public IDefaultProfile setBrowserPath(String browserPath){
        this.browserPath = browserPath;
        return this;
    }

    public IImplicitTimeOut setDefaultProfile(String defaultProfile) {
        this.defaultProfile = defaultProfile;
        return this;

    }

    public IExplicitTimeOut setImplicitTimeOut(long implicitTimeOut) {
        this.implicitTimeOut = implicitTimeOut;
        return this;
    }

    public ILanguage setExplicitTimeOut(long explicitTimeOut) {
        this.explicitTimeOut = explicitTimeOut;
        return this;
    }

    public ISearchStrategy setLanguage(String language) {
        this.language = language;
        return this;
    }

    public ILoggerStrategy setSearchStrategy(String searchStrategy) {
        this.searchStrategy = searchStrategy;
        return this;
    }
    public ILoginUrl setLoggerStrategy(String loggerStrategy) {
        this.loggerStrategy = loggerStrategy;
        return this;
    }

    public ILogoutUrl setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
        return this;
    }

    public IServerUrl setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
        return this;
    }

    public IBuild setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
        return this;
    }

    public ApplicationSources build() {
        return this;
    }

    //getters

    public String getBrowserName() {
        return browserName;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public String getBrowserPath() { return browserPath;}

    public String getDefaultProfile() { return defaultProfile;}

    public long getImplicitTimeOut() {
        return implicitTimeOut;
    }

    public long getExplicitTimeOut() {
        return explicitTimeOut;
    }

    public String getLanguage() {
        return language;
    }

    public String getSearchStrategy() {
        return searchStrategy;
    }

    public String getLoggerstrategy() { return loggerStrategy; }

    public String getLoginUrl() {
        return loginUrl;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public String serverUrl() {
        return serverUrl;
    }


}
