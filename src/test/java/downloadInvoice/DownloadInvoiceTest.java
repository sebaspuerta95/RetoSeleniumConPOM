package downloadInvoice;

import org.junit.jupiter.api.Test;
import testsBase.TestsBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DownloadInvoiceTest extends TestsBase {

    @Test
    public void testDownloadInvoiceAfterPurchaseOrder(){
        var allProductsPage = homePage.clickProductsButton();
        allProductsPage.scrollIntoProductsList();

        int firstProduct = 0;
        int secondProduct = 1;

        allProductsPage.hoverOverProduct(firstProduct);
        allProductsPage.clickOverlayingAddToCartButton(firstProduct);
        allProductsPage.clickContinueShoppingModalButton();

        allProductsPage.hoverOverProduct(secondProduct);
        allProductsPage.clickOverlayingAddToCartButton(secondProduct);
        allProductsPage.clickContinueShoppingModalButton();

        var viewCartPage = allProductsPage.clickViewCartNavBarButton();
        viewCartPage.scrollIntoCart();
        String expectedViewCartPageTitle = "Automation Exercise - Checkout";
        assertEquals(expectedViewCartPageTitle, viewCartPage.getViewCartTitle(), "The test didn't faill into the view cart page.");

        viewCartPage.clickProceedToCheckoutButton();
        var signupLoginPage = viewCartPage.clickRegisterLoginModalButton();
        String email = "sepuerta@gmail.com"; String password = "password123"; String username = "Sebas95";
        signupLoginPage.typeLoginEmailAndPassword(email, password);

        var landingPage = signupLoginPage.clickLoginButton();
        assertTrue(landingPage.getLoggedUser().contains(username), "The landing page doesn't contain the correct username");

        viewCartPage = landingPage.clickViewCartNavBarButton();
        viewCartPage.clickProceedToCheckoutButton();


    }

}
