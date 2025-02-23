package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProductsPage {

    private WebDriver driver;
    @FindBy(xpath = "//div[@class='features_items']")
    private WebElement allProductsList;

    @FindBy(xpath = "//a[contains(@href, '/product_details')]")
    private WebElement viewProductButton;

    public AllProductsPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public boolean isAllProductsListVisible(){
        return allProductsList.isDisplayed();
    }

    public ProductDetailsPage clickViewProductButtonOfFirstProductVisible(){
        viewProductButton.click();
        return new ProductDetailsPage(driver);
    }

    public void scrollIntoProductsList(){
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script,allProductsList);
    }

}
