package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class EmployeeSearch extends CommonMethods {

    @When("user clicks on EmployeeList option")
    public void user_clicks_on_employee_list_option() {
       // WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
       // click(empListOption);
        click(dashboardPage.empListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
       // WebElement empIdField = driver.findElement(By.id("empsearch_id"));
       // sendText(empIdField, "45154A");
        sendText(employeeList.empSearchField,"45154A");//replacing 2 lines to 1
    }
    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        //WebElement searchButton = driver.findElement(By.id("searchBtn"));
        //click(searchButton);
        click(employeeList.searchButton);
    }
    @Then("user sees employee information is displayed")
    public void user_sees_employee_information_is_displayed() {
        System.out.println("Employee information can be seen");
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
       // WebElement searchNameField = driver.findElement(By.id("empsearch_employee_name_empName"));
       // sendText(searchNameField, "dawggy");
        sendText(employeeList.empSearchNameField, "dawggy");
    }


}
