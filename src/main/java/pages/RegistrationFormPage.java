package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationFormPage {

    private WebDriver driver;
    private By enterAccInfo = By.xpath("//h2/b[text()='Enter Account Information']");
    private By mrButton = By.xpath("//input[@value='Mr']");
    private By mrsButton = By.xpath("//input[@value='Mrs']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By daysDropdown = By.xpath("//select[@id='days']");
    private By monthDropdown = By.xpath("//select[@id='months']");
    private By yearDropdown = By.xpath("//select[@id='years']");
    private By newsletterBox = By.xpath("//input[@id='newsletter']");
    private By optinBox = By.xpath("//input[@id='optin']");
    private By firstnameField = By.id("first_name");
    private By lastnameField = By.id("last_name");
    private By companyField = By.id("company");
    private By addressOneField = By.id("address1");
    private By addressTwoField = By.id("address2");
    private By countryDropdown = By.xpath("//select[@id='country']");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipCodeField = By.id("zipcode");
    private By numberField = By.id("mobile_number");
    private By createAccButton = By.xpath("//button[text()='Create Account']");

    public RegistrationFormPage (WebDriver driver){
        this.driver = driver;
    }

    public boolean isEnterInfoMessageVisible(){
        return driver.findElement(enterAccInfo).isDisplayed();
    }

    public String getEnterInfoMessage (){
        return driver.findElement(enterAccInfo).getText();
    }

    public void fillAccountInfoForm(String gender, String password, String day, String month, String year
            , String newsletter, String optin, String firstname, String lastname, String company, String addressOne
            , String addressTwo, String country, String state, String city, String zipCode, String mobileNumber){

        if (gender.equalsIgnoreCase("Male")){
            driver.findElement(mrButton).click();
        } else {
            driver.findElement(mrsButton).click();
        }

        driver.findElement(passwordField).sendKeys(password);
        selectFromDropdown(daysDropdown, day);
        selectFromDropdown(monthDropdown, month);
        selectFromDropdown(yearDropdown, year);
        if (newsletter.equalsIgnoreCase("Yes")) {driver.findElement(newsletterBox).click();}
        if (optin.equalsIgnoreCase("Yes")) {driver.findElement(optinBox).click();}
        driver.findElement(firstnameField).sendKeys(firstname);
        driver.findElement(lastnameField).sendKeys(lastname);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(addressOneField).sendKeys(addressOne);
        driver.findElement(addressTwoField).sendKeys(addressTwo);
        selectFromDropdown(countryDropdown, country);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipCodeField).sendKeys(zipCode);
        driver.findElement(numberField).sendKeys(mobileNumber);
    }

    public AccountCreatedPage clickCreateAccountButton(){
        driver.findElement(createAccButton).click();
        return new AccountCreatedPage(driver);
    }

    private Select findDropdownElement(By selector){
        return new Select(driver.findElement(selector));
    }

    public void selectFromDropdown (By selector, String option) {
        findDropdownElement(selector).selectByVisibleText(option);
    }

}
