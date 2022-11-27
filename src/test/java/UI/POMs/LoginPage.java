package UI.POMs;

import net.serenitybdd.core.pages.WebElementFacade;
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
        loginBtn.waitUntilClickable();
        typeInto(usernameField, username);
    }

    @Step
    public void inputPassword(String password) {
        loginBtn.waitUntilClickable();
        typeInto(passwordField, password);
    }

    @Step
    public void clickLoginBtn() {
        loginBtn.waitUntilClickable();
        clickOn(loginBtn);
    }

    @Step
    public void login(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickLoginBtn();
    }

    @Step
    public boolean loginBtnIsVisible() {
        loginBtn.waitUntilVisible();
        return loginBtn.isVisible();
    }
}
