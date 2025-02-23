package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {

    private WebDriver driver;
    private By accountCreatedInfo = By.xpath("//b[text()='Account Created!']");
    private By continueButton = By.xpath("//a[text()='Continue']");

    public AccountCreatedPage (WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAccCreatedMessageVisible(){
        return driver.findElement(accountCreatedInfo).isDisplayed();
    }

    public String getAccCreatedMessage(){
        return driver.findElement(accountCreatedInfo).getText();
    }

    public LandingPage clickContinueButton(){
        driver.findElement(continueButton).click();
        return new LandingPage(driver);
    }

}
