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

        viewCartPage.clickProceedToCheckoutButtonNotLoggedUser();
        var signupLoginPage = viewCartPage.clickRegisterLoginModalButton();
        String email = "sepuertabe@gmail.com"; String password = "password123"; String username = "Sebas95";
        signupLoginPage.typeLoginEmailAndPassword(email, password);

        var landingPage = signupLoginPage.clickLoginButton();
        assertTrue(landingPage.getLoggedUser().contains(username), "The landing page doesn't contain the correct username");
        viewCartPage = landingPage.clickViewCartNavBarButton();

        var checkoutPage = viewCartPage.clickProceedToCheckoutButtonLoggedUser();
        assertTrue(checkoutPage.isAddressDetailsLabelVisible(), "The address details are not present.");
        assertTrue(checkoutPage.isReviewOrderLabelVisible(), "The details of the order are not available in the screen.");
        String comment = "Very good purchase.";
        checkoutPage.typeInCommentArea(comment);

        var paymentDetailsPage = checkoutPage.clickPlaceOrderButton();
        String nameOnCard = "Sebastian P"; String cardNumber = "1234"; String cvc = "123"; String expMonth = "01"; String expYear = "2030";
        paymentDetailsPage.typePaymentInformation(nameOnCard, cardNumber, cvc, expMonth, expYear);

        var orderPlacedPage = paymentDetailsPage.clickPayAndConfirmOrderButton();
        String expectedConfirmationMessage = "Congratulations! Your order has been confirmed!";
        assertEquals(expectedConfirmationMessage, orderPlacedPage.getOrderConfirmationMessage(), "The confirmation message displayed was incorrect.");

        orderPlacedPage.clickDownloadInvoiceButton();
        String downloadPath = "C:\\Users\\sebas\\Downloads";
        String expectedFileName = "invoice.txt";
        assertTrue(orderPlacedPage.isInvoiceDownloaded(downloadPath, expectedFileName), "The invoice wasn't downloaded as expected.");

        landingPage = orderPlacedPage.clickContinueButton();
        landingPage.clickLogoutButton();
    }

}
