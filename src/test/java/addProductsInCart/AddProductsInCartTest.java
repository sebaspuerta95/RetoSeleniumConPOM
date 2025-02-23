package addProductsInCart;

import org.junit.jupiter.api.Test;
import testsBase.TestsBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddProductsInCartTest extends TestsBase {

    @Test
    public void testAddProductsInCart(){
        var allProductsPage = homePage.clickProductsButton();
        allProductsPage.scrollIntoProductsList();

        int firstProduct = 0;
        int secondProduct = 1;

        allProductsPage.hoverOverProduct(firstProduct);
        allProductsPage.clickOverlayingAddToCartButton(firstProduct);
        allProductsPage.clickContinueShoppingModalButton();

        allProductsPage.hoverOverProduct(secondProduct);
        allProductsPage.clickOverlayingAddToCartButton(secondProduct);
        var viewCartPage = allProductsPage.clickViewCartModalButton();

        int expectedProductsInCart = 2;
        assertEquals(expectedProductsInCart, viewCartPage.getNumberOfProductsAdded(), "The number of products added in the cart was incorrect.");

        int firstProductPrice = 500; int secondProductPrice = 400;
        assertEquals(firstProductPrice, viewCartPage.getProductPrice(firstProduct), "The price of the first product is incorrect.");
        assertEquals(secondProductPrice, viewCartPage.getProductPrice(secondProduct), "The price of the second product is incorrect.");

        int expectedQuantity = 1;
        assertEquals(expectedQuantity, viewCartPage.getProductQuantity(firstProduct), "The quantity of the first product is incorrect.");
        assertEquals(expectedQuantity, viewCartPage.getProductQuantity(secondProduct), "The quantity of the second product is incorrect.");

        int expectedTotalPrice = 900;
        int actualTotalPrice = viewCartPage.getTotalPrice(firstProduct) + viewCartPage.getTotalPrice(secondProduct);
        assertEquals(expectedTotalPrice, actualTotalPrice, "The total price of the products is incorrect.");

    }

}
