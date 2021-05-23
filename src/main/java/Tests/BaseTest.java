package Tests;

import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp(){
        setProperty();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    public static void setProperty(){

        Properties properties = System.getProperties();
        System.setProperty("webdriver.chrome.driver", properties.getProperty("user.dir") + "//drivers//chromedriver");
    }

    public void navigateUrl(String url){
        driver.get(url);
    }

}
