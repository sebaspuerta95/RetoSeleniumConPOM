package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationFormPage {

    private WebDriver driver;
    private By enterAccInfo = By.xpath("//h2/b[text()='Enter Account Information']");
    private By mrButton = By.xpath("//input[@value='Mr']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By daysDropdown = By.xpath("//select[@id='days']");
    private By monthDropdown = By.xpath("//select[@id='months']");
    private By yearDropdown = By.xpath("//select[@id='years']");
    private By newsletterBox = By.xpath("//input[@id='newsletter']");
    private By optinBox = By.xpath("//input[@id='optin']");
    private By firstnameField = By.id("first_name");
    private By lastnameField = By.id("last_name");
    private By companyyField = By.id("company");
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

    public String getEnterInfoMessage (){
        return driver.findElement(enterAccInfo).getText();
    }


}
