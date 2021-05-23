package Tests;

import Collections.LoginPageCollection;
import Collections.SignUpPageCollection;
import Pages.LoginPage;
import Pages.SignUpPage;
import Utilies.DriverWait;
import Utilies.Switch;
import org.junit.Assert;
import org.junit.Test;

public class LoginPageTest extends BaseTest{

    @Test
    public void correctLogin(){
        navigateUrl(LoginPageCollection.loginPageUrl);
        new LoginPage(driver).signIn(LoginPageCollection.correctUsername, LoginPageCollection.correctPassword);
        Assert.assertEquals(driver.getTitle(), "Lolaflora.com");
    }

    @Test
    public void incorrectLogin() {
        navigateUrl(LoginPageCollection.loginPageUrl);
        new LoginPage(driver).signIn(LoginPageCollection.incorrectUsername, LoginPageCollection.incorrectPassword);
        DriverWait.DriverWaitExpectedConditions(driver,LoginPage.alertModal);
        Assert.assertEquals(driver.findElement(LoginPage.alertModal).getText(), LoginPageCollection.incorrectMessage);
    }

    @Test
    public void requiredField() {
        navigateUrl(LoginPageCollection.loginPageUrl);
        new LoginPage(driver).signIn("", "");
        Assert.assertEquals(driver.findElement(LoginPage.requiredFieldEmail).getText(), LoginPageCollection.fieldEmptyMessage);
        Assert.assertEquals(driver.findElement(LoginPage.requiredFieldPassword).getText(), LoginPageCollection.fieldEmptyMessage);
    }

    @Test
    public void forgotPassword(){
        navigateUrl(LoginPageCollection.loginPageUrl);
        new LoginPage(driver).forgotPassword("test@test.com");
        Assert.assertTrue(driver.findElement(LoginPage.forgetSuccessIcon).isEnabled());

    }

    @Test
    public void clickSignUp(){
        navigateUrl(LoginPageCollection.loginPageUrl);
        new LoginPage(driver).clickSignUp();
        DriverWait.DriverWaitExpectedConditions(driver,SignUpPage.registerTextElement);
        Assert.assertEquals(driver.findElement(SignUpPage.registerTextElement).getText(), SignUpPageCollection.registerText);

    }

    @Test
    public void clickSignInWithFacebook(){
        navigateUrl(LoginPageCollection.loginPageUrl);
        new LoginPage(driver).clickSignInWithFacebook();
        Switch.SwitchWindow(driver);
        Assert.assertEquals(driver.getTitle(), LoginPageCollection.facebookWindowTitle);

    }

}
