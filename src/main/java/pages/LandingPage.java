package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    private WebDriver driver;
    @FindBy (xpath = "\"//a[contains(text(), 'Logged in as')]/b\"")
    private WebElement loggedUserButton;

    @FindBy (xpath = "//a[@href='/delete_account']")
    private WebElement deleteAccButton;

    @FindBy(xpath = "//ul/li/a[@href='/view_cart']")
    private WebElement viewCartButton;

    @FindBy (xpath = "//a[@href='/logout']")
    private WebElement logoutButton;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    public void clickLogoutButton(){
        logoutButton.click();
    }

}
