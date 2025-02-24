package downloadInvoice;

import org.junit.jupiter.api.Test;
import testsBase.TestsBase;

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



    }

}
