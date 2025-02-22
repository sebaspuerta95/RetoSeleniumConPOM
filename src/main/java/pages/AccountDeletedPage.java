package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDeletedPage {

    private WebDriver driver;
    private By accountDeletedInfo = By.xpath("//b[text()='Account Deleted!']");
    private By continueButton = By.xpath("//a[text()='Continue']");

    public AccountDeletedPage (WebDriver driver){
        this.driver = driver;
    }

    public String getAccDeletedMessage(){
        return driver.findElement(accountDeletedInfo).getText();
    }

    public HomePage clickContinueButton(){
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }

}
