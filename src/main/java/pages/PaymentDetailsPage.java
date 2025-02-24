package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentDetailsPage {

    private WebDriver driver;
    @FindBy (xpath = "//input[@name='name_on_card']")
    private WebElement nameOnCardField;

    @FindBy (xpath = "//input[@name='card_number']")
    private WebElement cardNumberField;

    @FindBy (xpath = "//input[@name='cvc']")
    private WebElement cvcField;

    @FindBy (xpath = "//input[@name='expiry_month']")
    private WebElement expMonthField;

    @FindBy (xpath = "//input[@name='expiry_year']")
    private WebElement expYearField;

    @FindBy (xpath = "//button[@id='submit']")
    private WebElement payAndConfirmOrderButton;

    public PaymentDetailsPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typePaymentInformation(String nameOnCard, String cardNumber, String cvc, String expMonth, String expYear){
        nameOnCardField.sendKeys(nameOnCard);
        cardNumberField.sendKeys(cardNumber);
        cvcField.sendKeys(cvc);
        expMonthField.sendKeys(expMonth);
        expYearField.sendKeys(expYear);
    }

    public OrderPlacedPage clickPayAndConfirmOrderButton(){
        payAndConfirmOrderButton.click();
        return new OrderPlacedPage(driver);
    }

}
