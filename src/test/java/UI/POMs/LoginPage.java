package UI.POMs;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id = "user-name")
    private WebElementFacade usernameField;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(id = "login-button")
    private WebElementFacade loginBtn;

    @Step
    public void inputUsername(String username) {
        usernameField.waitUntilClickable();
        usernameField.type(username);
    }

    @Step
    public void inputPassword(String password) {
        passwordField.waitUntilClickable();
        passwordField.type(password);
    }

    @Step
    public void clickLoginBtn() {
        loginBtn.waitUntilClickable();
        loginBtn.click();
    }

    @Step
    public void login(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickLoginBtn();
    }

    @Step
    public WebElementState loginBtn() {
        return loginBtn;
    }
}
