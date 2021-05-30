package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    By userName = By.id("EmailLogin");
    By password = By.id("Password");
    By btnLogin = By.cssSelector("#userLogin > div:nth-child(6) > button");
    By btnForgotPassword = By.cssSelector("#userLogin > div:nth-child(6) > a");
    By textForgotPassword = By.id("Mail");
    By btnForgetPswSend = By.cssSelector("body > main > div > div:nth-child(1) > div >" +
            " form.form-password-recovery.js-password-recovery.is-hidden > div:nth-child(3) > button");
    By btnSignUp = By.cssSelector("body > main > div > div:nth-child(2) > div > a.membership-advantages__button--member-login.btn.btn-warning.btn-lg");
    By btnSignInWithFacebook = By.cssSelector("body > main > div > div:nth-child(2) > div > a.login__facebook.btn.btn-info.btn-xlg.full-width");

    public static By alertModal = By.cssSelector("#modalBox > div > div > div.modal-body");
    public static By requiredFieldEmail = By.id("EmailLogin-error");
    public static By requiredFieldPassword = By.id("Password-error");
    public static By forgetSuccessIcon = By.cssSelector("body > main > div > div:nth-child(1) > div > div > span");

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
