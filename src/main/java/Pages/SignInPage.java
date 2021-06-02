package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    By userName = By.id("EmailLogin");
    By password = By.id("Password");
    By btnLogin = By.className("js-login-button");
    By btnForgotPassword = By.className("js-forgot-password");
    By textForgotPassword = By.id("Mail");
    By btnForgetPswSend = By.className("js-password-recovery-button");
    By btnSignUp = By.className("btn-warning");
    By btnSignInWithFacebook = By.className("login__social-text");

    public static By alertModal = By.className("modal-body");
    public static By requiredFieldEmail = By.id("EmailLogin-error");
    public static By requiredFieldPassword = By.id("Password-error");
    public static By forgetSuccessIcon = By.className("password-recovery-result__icon");

    private final WebDriver  driver;

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    public void signIn(String username, String password){
        driver.findElement(userName).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(btnLogin).click();
    }

    public void forgotPassword(String email){
        driver.findElement(btnForgotPassword).click();
        driver.findElement(textForgotPassword).sendKeys(email);
        driver.findElement(btnForgetPswSend).click();
    }

    public void clickSignUp(){
        driver.findElement(btnSignUp).click();
    }

    public void clickSignInWithFacebook(){
        driver.findElement(btnSignInWithFacebook).click();
    }

}
