package Tests;

import Collections.SignInPageCollection;
import Collections.SignUpPageCollection;
import Pages.SignInPage;
import Pages.SignUpPage;
import Utilies.DriverWait;
import Utilies.Switch;
import org.junit.Assert;
import org.junit.Test;

public class SignInPageTest extends BaseTest{

    @Test
    public void correctLogin(){
        navigateUrl(SignInPageCollection.loginPageUrl);
        new SignInPage(driver).signIn(SignInPageCollection.correctUsername, SignInPageCollection.correctPassword);
        Assert.assertEquals(driver.getTitle(), "Lolaflora.com");
    }

    @Test
    public void incorrectLogin() {
        navigateUrl(SignInPageCollection.loginPageUrl);
        new SignInPage(driver).signIn(SignInPageCollection.incorrectUsername, SignInPageCollection.incorrectPassword);
        DriverWait.driverWaitExpectedConditions(driver, SignInPage.alertModal);
        Assert.assertEquals(driver.findElement(SignInPage.alertModal).getText(), SignInPageCollection.incorrectMessage);
    }

    @Test
    public void requiredField() {
        navigateUrl(SignInPageCollection.loginPageUrl);
        new SignInPage(driver).signIn("", "");
        Assert.assertEquals(driver.findElement(SignInPage.requiredFieldEmail).getText(), SignInPageCollection.fieldEmptyMessage);
        Assert.assertEquals(driver.findElement(SignInPage.requiredFieldPassword).getText(), SignInPageCollection.fieldEmptyMessage);
    }

    @Test
    public void forgotPassword(){
        navigateUrl(SignInPageCollection.loginPageUrl);
        new SignInPage(driver).forgotPassword("test@test.com");
        Assert.assertTrue(driver.findElement(SignInPage.forgetSuccessIcon).isEnabled());

    }

    @Test
    public void clickSignUp(){
        navigateUrl(SignInPageCollection.loginPageUrl);
        new SignInPage(driver).clickSignUp();
        DriverWait.driverWaitExpectedConditions(driver,SignUpPage.registerTextElement);
        Assert.assertEquals(driver.findElement(SignUpPage.registerTextElement).getText(), SignUpPageCollection.registerText);

    }

    @Test
    public void clickSignInWithFacebook(){
        navigateUrl(SignInPageCollection.loginPageUrl);
        new SignInPage(driver).clickSignInWithFacebook();
        Switch.SwitchWindow(driver);
        Assert.assertEquals(driver.getTitle(), SignInPageCollection.facebookWindowTitle);

    }

}
