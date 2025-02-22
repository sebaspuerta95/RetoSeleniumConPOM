package registerUser;

import org.junit.jupiter.api.Test;
import testsBase.TestsBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterUserTest extends TestsBase {

    @Test
    public void testRegisterNewUser(){
        var signUpLoginPage = homePage.clickSignUpLoginButton();

        String expectedSignUpMessage = "New User Signup!";
        assertTrue(signUpLoginPage.isSingUpMessageVisible(), "The Signup message is not visible on the screen.");
        assertEquals(signUpLoginPage.getSignUpMessage(), expectedSignUpMessage, "The Sign Up message is incorrect.");

        String username = "Sebas95"; String email = "sebastian@gmail.com";
        signUpLoginPage.typeNameAndEmail(username, email);
        var registrationFormPage = signUpLoginPage.clickSignUpButton();

        String expectedEnterInfoMessage = "ENTER ACCOUNT INFORMATION";
        assertTrue(registrationFormPage.isEnterInfoMessageVisible(), "The Enter Account Information message is not visible on the screen.");
        assertEquals(registrationFormPage.getEnterInfoMessage(), expectedEnterInfoMessage, "The Enter Acc Info message is incorrect.");

        String gender = "Male"; String password = "Pass123"; String day = "13"; String month = "August"; String year = "1995";
        String newsletter = "Yes"; String optin = "Yes"; String firstname = "Sebastian"; String lastname = "Puerta"; String company = "Sofka";
        String addressOne = "123 Address 1"; String addressTwo = "123 Address 2"; String country = "United States";
        String state = "State X"; String city = "City Y"; String zipCode = "12345"; String mobileNumber = "123456789";

        registrationFormPage.fillAccountInfoForm(gender, password, day, month, year, newsletter, optin, firstname
                , lastname, company, addressOne, addressTwo, country, state, city, zipCode, mobileNumber);
        var accountCreatedPage = registrationFormPage.clickCreateAccountButton();

        String expectedAccCreatedMessage = "ACCOUNT CREATED!";
        assertTrue(accountCreatedPage.isAccCreatedMessageVisible(), "The Account Created message is not visible.");
        assertEquals(accountCreatedPage.getAccCreatedMessage(), expectedAccCreatedMessage, "The Account Created message is incorrect.");
        var landingPage = accountCreatedPage.clickContinueButton();

        assertTrue(landingPage.isLoggedUserVisible(), "The logged user message is not visible.");
        assertTrue(landingPage.getLoggedUser().contains(username), "The landing page doesn't contain the correct username");
        var accountDeletedPage = landingPage.clickDeleteAccountButton();

        String expectedAccDelMessage = "ACCOUNT DELETED!";
        assertTrue(accountDeletedPage.isAccDeletedMessageVisible(), "The Account Deleted message is not visible.");
        assertEquals(accountDeletedPage.getAccDeletedMessage(), expectedAccDelMessage, "The Account Deleted message is incorrect.");
        accountDeletedPage.clickContinueButton();
    }

}
