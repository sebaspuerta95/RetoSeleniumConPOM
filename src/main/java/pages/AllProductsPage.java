package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllProductsPage {

    private WebDriver driver;
    @FindBy(xpath = "//div[@class='features_items']")
    private WebElement allProductsList;

    @FindBy(xpath = "//a[contains(@href, '/product_details')]")
    private WebElement viewProductButton;

    @FindBy(xpath = "//div[@class='single-products']")
    private List<WebElement> productBodies;

    @FindBy(xpath = "//div[@class='product-overlay']//a[@class='btn btn-default add-to-cart']")
    private List<WebElement> overlayingAddToCartButtons;

    @FindBy(xpath = "//div[@class='modal-body']/p/a")
    private WebElement viewCartModalButton;

    @FindBy(xpath = "//div[@class='modal-footer']/button")
    private WebElement continueShoppingModalButton;

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

    public void hoverOverProduct(int index){
        Actions actions = new Actions(driver);
        actions.moveToElement(productBodies.get(index)).perform();
    }

    public void clickOverlayingAddToCartButton(int index){
        overlayingAddToCartButtons.get(index).click();
    }

    public void clickContinueShoppingModalButton(){
        continueShoppingModalButton.click();
    }

    public ViewCartPage clickViewCartModalButton(){
        viewCartModalButton.click();
        return new ViewCartPage(driver);
    }

}
