package com.gsmserver.testbase;
import com.codeborne.selenide.Configuration;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public static Properties prop;
    public static Logger log = Logger.getLogger(TestBase.class);
    public static WebElement element;
    public static DesiredCapabilities dc;
    public static JavascriptExecutor js;

    public TestBase(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("G:\\MentorRoman\\GsmServerTask_1\\src\\main\\java\\com.gsmsever.config\\config.properties");
            prop.load(ip);
            log.info("getting data from config file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization (){
        String browserName = prop.getProperty("browser");
            if (browserName.equals("chrome")){
                Configuration.browser = "chrome";
                Configuration.browserSize = "1920x1080";
                Configuration.holdBrowserOpen = true;
                log.info("launching Chrome browser");
            } else if (browserName.equals("firefox")){
                Configuration.browser = "firefox";
                Configuration.browserSize = "1920x1080";
                Configuration.holdBrowserOpen = true;
                log.info("launching Chrome browser");
                log.info("launching FF browser");
            } else if (browserName.equals("IE")){
                Configuration.browser = "IE";
                Configuration.browserSize = "1920x1080";
                Configuration.holdBrowserOpen = true;
                log.info("launching IE browser");
            } else if (browserName.equals("EDGE")){
                Configuration.browser = "IE";
                Configuration.browserSize = "1920x1080";
                Configuration.holdBrowserOpen = true;
                log.info("launching EDGE browser");
            }
}
}
