package Utilies;

import org.openqa.selenium.WebDriver;


public class Switch {

    public static void SwitchWindow(WebDriver driver){
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

}
