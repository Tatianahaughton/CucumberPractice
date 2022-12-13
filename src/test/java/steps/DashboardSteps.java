package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class DashboardSteps extends CommonMethods {
    @Then("user verify dashboard page")
    public void userVerifyDashboardPage() {
        System.out.println("Batch 14");
    }

    @Then("user verifies all dashboard tabs")
    public void user_verifies_all_dashboard_tabs(DataTable dataTable) {
        List<String>expectedTabs=dataTable.asList();//tabs coming from data Table as List

        List<String> actualTabs= new ArrayList<>();
        for (WebElement ele:dashboardPage.dashboardTabs
             ) {
            actualTabs.add(ele.getText());
        }

        System.out.println(expectedTabs);
        System.out.println(actualTabs);
        Assert.assertTrue(expectedTabs.equals(actualTabs));
    }
}
