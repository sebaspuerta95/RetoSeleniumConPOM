package verifyAllProductsAndPDP;

import org.junit.jupiter.api.Test;
import testsBase.TestsBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerifyProductsAndPDDTest extends TestsBase {

    @Test
    public void testVerificationOfProductsListAndPDP(){
        var allProductsPage = homePage.clickProductsButton();

        String expectedProductsListTitle = "All Products";
        assertEquals(expectedProductsListTitle, allProductsPage.getPageTitle(), "The page didn't land on the All Product page.");
        assertTrue(allProductsPage.isAllProductsListVisible(), "The list of all the products is not visible.");
        var productDetailsPage = allProductsPage.clickViewProductButtonOfFirstProductVisible();

        String expectedPDPTitle = "Product Details";
        assertEquals(expectedPDPTitle, productDetailsPage.getPageTitle(), "The page didn't land on the Product Details page.");

        assertTrue(productDetailsPage.isProductNameVisible(), "The product name tag is not visible on the page.");
        assertTrue(productDetailsPage.isProductCategoryVisible(), "The product category tag is not visible on the page.");
        assertTrue(productDetailsPage.isProductPriceVisible(), "The product price tag is not visible on the page.");
        assertTrue(productDetailsPage.isProductAvailabilityVisible(), "The product availability tag is not visible on the page.");
        assertTrue(productDetailsPage.isProductConditionVisible(), "The product condition tag is not visible on the page.");
        assertTrue(productDetailsPage.isProductBrandVisible(), "The product brand tag is not visible on the page.");


    }

}
