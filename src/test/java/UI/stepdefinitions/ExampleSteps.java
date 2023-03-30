package UI.stepdefinitions;

import UI.POMs.HomePage;
import UI.POMs.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ExampleSteps {

    @Steps
    private LoginPage loginPage;
    @Steps
    private HomePage homePage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        String applicationDate = System.getProperty("applicationDate");
        switch (applicationDate) {
            case "current":
                Date date = new Date();
                SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
                String strDate = dateFormatter.format(date);
                System.out.println(strDate);
                break;
            default:
                System.out.println(applicationDate);
                break;
        }
        loginPage.open();
        assertThat("Failed to open login page", loginPage.loginBtn().isVisible(), is(true));
    }

    @When("I login")
    public void i_login(DataTable dataTable) {
        Map<String, String> loginDetails = dataTable.asMap();
        loginPage.login(loginDetails.get("username"), loginDetails.get("password"));
    }
    @Then("I should be on the home page")
    public void i_should_be_on_the_home_page() {
        assertThat("Login was unsuccessful", homePage.shoppingCart().isClickable(), is(true));
    }
}
