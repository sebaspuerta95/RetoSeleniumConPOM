package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProductsPage {

    private WebDriver driver;
    @FindBy(xpath = "//div[@class='features_items']")
    private WebElement allProductsList;

    @FindBy(xpath = "//a[contains(@href, '/product_details')]")
    private WebElement viewProductButton;

    public AllProductsPage (WebDriver driver){
        this.driver = driver;
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public boolean isAllProductsListVisible(){
        return allProductsList.isDisplayed();
    }

    public void clickViewProductButtonOfFirstProductVisible(){
        viewProductButton.click();
    }


}
