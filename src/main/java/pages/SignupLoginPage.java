package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupLoginPage {

    private WebDriver driver;
    @FindBy (xpath = "//div[@class='signup-form']/h2")
    private WebElement signUpMessage;

    @FindBy (xpath = "//input[@data-qa='signup-name']")
    private WebElement signUpNameField;

    @FindBy (xpath = "//input[@data-qa='signup-email']")
    private WebElement signUpEmailField;

    @FindBy (xpath = "//button[@data-qa='signup-button']")
    private WebElement signUpButton;

    @FindBy (xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmailField;

    @FindBy (xpath = "//input[@data-qa='login-password']")
    private WebElement loginPasswordField;

    @FindBy (xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    public SignupLoginPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isSingUpMessageVisible(){
        return signUpMessage.isDisplayed();
    }

    public String getSignUpMessage (){
        return signUpMessage.getText();
    }

    public void typeSignUpNameAndEmail(String name, String email){
        signUpNameField.sendKeys(name);
        signUpEmailField.sendKeys(email);
    }

    public RegistrationFormPage clickSignUpButton(){
        signUpButton.click();
        return new RegistrationFormPage(driver);
    }

    public void typeLoginEmailAndPassword (String email, String password){
        loginEmailField.sendKeys(email);
        loginPasswordField.sendKeys(password);
    }

    public LandingPage clickLoginButton(){
        loginButton.click();
        return new LandingPage(driver);
    }

}
