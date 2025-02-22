package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage {

    private WebDriver driver;
    private By signUpMessage = By.xpath("//div[@class='signup-form']/h2");
    private By signUpNameField = By.xpath("//input[@data-qa='signup-name']");
    private By signUpEmailField = By.xpath("//input[@data-qa='signup-email']");
    private By signUpButton = By. xpath("//button[@data-qa='signup-button']");

    public SignupLoginPage (WebDriver driver){
        this.driver = driver;
    }

    public String getSignUpMessage (){
        return driver.findElement(signUpMessage).getText();
    }

    public void typeNameAndEmail (String name, String email){
        driver.findElement(signUpNameField).sendKeys(name);
        driver.findElement(signUpEmailField).sendKeys(email);
    }

    public RegistrationFormPage clickSignUpButton(){
        driver.findElement(signUpButton).click();
        return new RegistrationFormPage(driver);
    }

}
