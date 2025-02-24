package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationFormPage {

    private WebDriver driver;

    @FindBy(xpath = "//h2/b[text()='Enter Account Information']")
    private WebElement enterAccInfo;

    @FindBy(xpath = "//input[@value='Mr']")
    private WebElement mrButton;

    @FindBy(xpath = "//input[@value='Mrs']")
    private WebElement mrsButton;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//select[@id='days']")
    private WebElement daysDropdown;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement monthDropdown;

    @FindBy(xpath = "//select[@id='years']")
    private WebElement yearDropdown;

    @FindBy(xpath = "//input[@id='newsletter']")
    private WebElement newsletterBox;

    @FindBy(xpath = "//input[@id='optin']")
    private WebElement optinBox;

    @FindBy(id = "first_name")
    private WebElement firstnameField;

    @FindBy(id = "last_name")
    private WebElement lastnameField;

    @FindBy(id = "company")
    private WebElement companyField;

    @FindBy(id = "address1")
    private WebElement addressOneField;

    @FindBy(id = "address2")
    private WebElement addressTwoField;

    @FindBy(xpath = "//select[@id='country']")
    private WebElement countryDropdown;

    @FindBy(id = "state")
    private WebElement stateField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "zipcode")
    private WebElement zipCodeField;

    @FindBy(id = "mobile_number")
    private WebElement numberField;

    @FindBy(xpath = "//button[text()='Create Account']")
    private WebElement createAccButton;

    public RegistrationFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isEnterInfoMessageVisible() {
        return enterAccInfo.isDisplayed();
    }

    public String getEnterInfoMessage() {
        return enterAccInfo.getText();
    }

    public void fillAccountInfoForm(String gender, String password, String day, String month, String year,
                                    String newsletter, String optin, String firstname, String lastname,
                                    String company, String addressOne, String addressTwo, String country,
                                    String state, String city, String zipCode, String mobileNumber) {

        if (gender.equalsIgnoreCase("Male")) {
            mrButton.click();
        } else {
            mrsButton.click();
        }

        passwordField.sendKeys(password);
        selectFromDropdown(daysDropdown, day);
        selectFromDropdown(monthDropdown, month);
        selectFromDropdown(yearDropdown, year);

        if (newsletter.equalsIgnoreCase("Yes")) {
            newsletterBox.click();
        }
        if (optin.equalsIgnoreCase("Yes")) {
            optinBox.click();
        }

        firstnameField.sendKeys(firstname);
        lastnameField.sendKeys(lastname);
        companyField.sendKeys(company);
        addressOneField.sendKeys(addressOne);
        addressTwoField.sendKeys(addressTwo);
        selectFromDropdown(countryDropdown, country);
        stateField.sendKeys(state);
        cityField.sendKeys(city);
        zipCodeField.sendKeys(zipCode);
        numberField.sendKeys(mobileNumber);
    }

    public AccountCreatedPage clickCreateAccountButton() {
        createAccButton.click();
        return new AccountCreatedPage(driver);
    }

    public void selectFromDropdown(WebElement dropdown, String option) {
        new Select(dropdown).selectByVisibleText(option);
    }
}
