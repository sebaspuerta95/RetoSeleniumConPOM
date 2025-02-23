package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    private WebDriver driver;
    private By loggedUserButton = By.xpath("//a[contains(text(), 'Logged in as')]/b");
    private By deleteAccButton = By.xpath("//a[@href='/delete_account']");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoggedUser(){
        return driver.findElement(loggedUserButton).getText();
    }

    public boolean isLoggedUserVisible(){
        return driver.findElement(loggedUserButton).isDisplayed();
    }

    public AccountDeletedPage clickDeleteAccountButton(){
        driver.findElement(deleteAccButton).click();
        return new AccountDeletedPage(driver);
    }

}
