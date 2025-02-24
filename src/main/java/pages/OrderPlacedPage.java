package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class OrderPlacedPage {

    private WebDriver driver;
    @FindBy (xpath = "//p[contains(text(), 'Congratulations!')]")
    private WebElement orderConfirmationMessage;

    @FindBy (xpath = "//a[text()='Download Invoice']")
    private WebElement downloadInvoiceButton;

    @FindBy (xpath = "//a[text()='Continue']")
    private WebElement continueButton;

    public OrderPlacedPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getOrderConfirmationMessage(){
        return orderConfirmationMessage.getText();
    }

    public void clickDownloadInvoiceButton(){
        downloadInvoiceButton.click();
    }

    public boolean isInvoiceDownloaded(String downloadPath, String fileName){
        File file = new File(downloadPath + "\\" + fileName);
        int waitTime = 10;

        while (waitTime > 0) {
            if (file.exists()) {
                return true;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            waitTime--;
        }
        return false;
    }

    public LandingPage clickContinueButton(){
        continueButton.click();
        return new LandingPage(driver);
    }

}
