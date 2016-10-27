/**
 * Created by ovo on 27.10.2016.
 */
public class WebDriver {
    private static WebDriver ourInstance = new WebDriver();

    public static WebDriver getInstance() {
        return ourInstance;
    }

    private WebDriver() {
    }
}
