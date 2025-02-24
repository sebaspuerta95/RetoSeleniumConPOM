package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private WebDriver driver;
    @FindBy (xpath = "//h2[text()='Address Details']")
    private WebElement addressDetailsLabel;

    @FindBy (xpath = "//h2[text()='Review Your Order']")
    private WebElement reviewOrderLabel;

    @FindBy (xpath = "//textarea[@class='form-control']")
    private WebElement commentArea;

    @FindBy (xpath = "//a[@href='/payment']")
    private WebElement placeOrderButton;

    public CheckoutPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isAddressDetailsLabelVisible(){
        return addressDetailsLabel.isDisplayed();
    }

    public boolean isReviewOrderLabelVisible(){
        return reviewOrderLabel.isDisplayed();
    }

    public void typeInCommentArea(String comment){
        commentArea.sendKeys(comment);
    }

    public PaymentDetailsPage clickPlaceOrderButton(){
        placeOrderButton.click();
        return new PaymentDetailsPage(driver);
    }

}
