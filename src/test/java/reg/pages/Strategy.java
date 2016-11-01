package reg.pages;

import reg.apps.ApplicationSources;
import reg.apps.ApplicationSourcesRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ovo on 01.11.2016.
 */
public class Strategy {
    private interface IElement {
        Strategy getElement(Application application);
    }

    private static class XPAth implements Strategy.IElement {
        public Strategy getElement(Strategy strategy) {
            System.setProperty("f",
                    strategy.applicationSources.getSearchStrategy());
            return new FirefoxDriver();
        }
    }

    private static class ChromeTemporary implements Application.IBrowser {
        public WebDriver getBrowser(Application application) {
            System.setProperty("webdriver.chrome.driver",
                    application.applicationSources.getDriverPath());
            return new ChromeDriver();
        }
    }

    private static class HtmlUnitTemporary implements Application.IBrowser {
        public WebDriver getBrowser(Application application) {
            WebDriver driver = null;
            return driver;
        }
    }

    public static enum Browsers {
        DEFAULT_STRATEGY("ChromeTemporary", new Application.ChromeTemporary()),
        FIREFOX_TEMPORARY("FireFoxTemporary", new Application.FirefoxTemporary()),
        CHROME_TEMPORARY("ChromeTemporary", new Application.ChromeTemporary()),
        HTMLUNIT_TEMPORARY("HtmlUnitTemporary", new Application.HtmlUnitTemporary());
        //
        private String browserName;
        private Application.IBrowser browser;

        private Browsers(String browserName, Application.IBrowser browser) {
            this.browserName = browserName;
            this.browser = browser;
        }

        public WebDriver runBrowser(Application application) {

            return browser.getBrowser(application);
        }

        @Override
        public String toString() {
            return browserName;
        }
    }

    // fields

    private static volatile Application instance;
    private WebDriver driver;
    private ApplicationSources applicationSources;

    private Strategy(ApplicationSources applicationSources) {
        this.applicationSources = applicationSources;
    }

    public static Application get() {
        return get(null);
    }

    public static Application get(ApplicationSources applicationSources) {
        if (instance == null) {
            synchronized (Application.class) {
                if (instance == null) {
                    if (applicationSources == null) {
                        applicationSources = ApplicationSourcesRepository.getDefault();
                    }
                    instance = new Application(applicationSources);
                    instance.init();
                }
            }
        }
        return instance;
    }
}
