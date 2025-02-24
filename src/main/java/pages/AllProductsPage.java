package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AllProductsPage {

    private WebDriver driver;
    @FindBy(xpath = "//ul/li/a[@href='/view_cart']")
    private WebElement viewCartButton;

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

    @FindBy(xpath = "//div[@class='modal-content']")
    private WebElement modalContent;

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
        modalScreenWait();
        continueShoppingModalButton.click();
    }

    public ViewCartPage clickViewCartModalButton(){
        modalScreenWait();
        viewCartModalButton.click();
        return new ViewCartPage(driver);
    }

    private void modalScreenWait(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(modalContent));
    }

    public ViewCartPage clickViewCartNavBarButton(){
        viewCartButton.click();
        return new ViewCartPage(driver);
    }

}
