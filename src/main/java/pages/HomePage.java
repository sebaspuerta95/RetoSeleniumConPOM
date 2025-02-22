package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public void clickLink (String textLink){
        driver.findElement(By.linkText(textLink)).click();
    }



}
