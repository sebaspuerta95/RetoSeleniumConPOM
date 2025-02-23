package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewCartPage {

    private WebDriver driver;

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> cartProductsList;

    @FindBy(xpath ="//td[@class='cart_price']/p")
    private List<WebElement> cartPricesList;

    @FindBy(xpath = "//td[@class='cart_quantity']/button")
    private List<WebElement> cartQuantitiesList;

    @FindBy(xpath = "//td[@class='cart_total']/p")
    private List<WebElement> totalPricesList;

    public ViewCartPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getNumberOfProductsAdded(){
        return cartProductsList.size();
    }

    public String getProductPrice(int index){
        return cartPricesList.get(index).getText();
    }

    public String getProductQuantity(int index){
        return cartQuantitiesList.get(index).getText();
    }

    public String getTotalPrice(int index){
        return totalPricesList.get(index).getText();
    }

}
