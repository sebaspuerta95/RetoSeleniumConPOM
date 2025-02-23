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

    public int getProductPrice(int index){
        String priceInString = cartPricesList.get(index).getText();
        return Integer.parseInt(priceInString);
    }

    public int getProductQuantity(int index){
        String quantityInString = cartQuantitiesList.get(index).getText();
        return Integer.parseInt(quantityInString);
    }

    public int getTotalPrice(int index){
        String totalPriceInString = totalPricesList.get(index).getText();
        String totalPriceNumbers = totalPriceInString.replaceAll("[^0-9]", "");
        return Integer.parseInt(totalPriceNumbers);
    }

}
