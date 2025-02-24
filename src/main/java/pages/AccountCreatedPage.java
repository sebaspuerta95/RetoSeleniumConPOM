package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {

    private WebDriver driver;
    @FindBy (xpath = "//b[text()='Account Created!']")
    private WebElement accountCreatedInfo;

    @FindBy (xpath = "//a[text()='Continue']")
    private WebElement continueButton;

    public AccountCreatedPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAccCreatedMessageVisible(){
        return accountCreatedInfo.isDisplayed();
    }

    public String getAccCreatedMessage(){
        return accountCreatedInfo.getText();
    }

    public LandingPage clickContinueButton(){
        continueButton.click();
        return new LandingPage(driver);
    }

}
