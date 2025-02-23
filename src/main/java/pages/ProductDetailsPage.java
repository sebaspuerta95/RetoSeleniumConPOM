package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

    private WebDriver driver;
    @FindBy(xpath ="//div[@class='product-information']/h2")
    private WebElement productNameLabel;

    @FindBy(xpath ="(//div[@class='product-information']/p)[1]")
    private WebElement categoryLabel;

    @FindBy(xpath ="//div[@class='product-information']/span/span")
    private WebElement priceLabel;

    @FindBy(xpath ="(//div[@class='product-information']/p)[2]")
    private WebElement availabilityLabel;

    @FindBy(xpath ="(//div[@class='product-information']/p)[3]")
    private WebElement conditionLabel;

    @FindBy(xpath ="(//div[@class='product-information']/p)[4]")
    private WebElement brandLabel;

    public ProductDetailsPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public boolean isProductNameVisible(){
        return productNameLabel.isDisplayed();
    }

    public boolean isProductCategoryVisible(){
        return categoryLabel.isDisplayed();
    }

    public boolean isProductPriceVisible(){
        return priceLabel.isDisplayed();
    }

    public boolean isProductAvailabilityVisible(){
        return availabilityLabel.isDisplayed();
    }

    public boolean isProductConditionVisible(){
        return conditionLabel.isDisplayed();
    }

    public boolean isProductBrandVisible(){
        return brandLabel.isDisplayed();
    }

}
