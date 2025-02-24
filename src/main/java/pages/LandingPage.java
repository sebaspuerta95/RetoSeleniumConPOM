package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

    private WebDriver driver;
    @FindBy (xpath = "\"//a[contains(text(), 'Logged in as')]/b\"")
    private WebElement loggedUserButton;

    @FindBy (xpath = "//a[@href='/delete_account']")
    private WebElement deleteAccButton;

    @FindBy(xpath = "//ul/li/a[@href='/view_cart']")
    private WebElement viewCartButton;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoggedUser(){
        return loggedUserButton.getText();
    }

    public boolean isLoggedUserVisible(){
        return loggedUserButton.isDisplayed();
    }

    public AccountDeletedPage clickDeleteAccountButton(){
        deleteAccButton.click();
        return new AccountDeletedPage(driver);
    }

    public ViewCartPage clickViewCartNavBarButton(){
        viewCartButton.click();
        return new ViewCartPage(driver);
    }

}
