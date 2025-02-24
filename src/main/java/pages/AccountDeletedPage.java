package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletedPage {

    private WebDriver driver;
    @FindBy (xpath = "//b[text()='Account Deleted!']")
    private WebElement accountDeletedInfo;

    @FindBy (xpath = "//a[text()='Continue']")
    private WebElement continueButton;

    public AccountDeletedPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAccDeletedMessageVisible(){
        return accountDeletedInfo.isDisplayed();
    }

    public String getAccDeletedMessage(){
        return accountDeletedInfo.getText();
    }

    public void clickContinueButton(){
        continueButton.click();
    }

}
