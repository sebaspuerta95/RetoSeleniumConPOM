package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By signUpLoginButton = By.xpath("//a[@href='/login']");

    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public SignupLoginPage clickSignUpLoginButton(){
        driver.findElement(signUpLoginButton).click();
        return new SignupLoginPage(driver);
    }



}
