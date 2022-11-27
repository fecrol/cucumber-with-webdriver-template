package UI.POMs;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(className = "shopping_cart_link")
    private WebElementFacade shoppingCart;

    @Step
    public boolean shoppingCartIsClickable() {
        shoppingCart.waitUntilClickable();
        return shoppingCart.isClickable();
    }
}
