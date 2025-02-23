package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement signUpLoginButton;

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productsButton;

    public HomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignupLoginPage clickSignUpLoginButton(){
        signUpLoginButton.click();
        return new SignupLoginPage(driver);
    }

    public AllProductsPage clickProductsButton(){
        productsButton.click();
        return new AllProductsPage(driver);
    }

}
