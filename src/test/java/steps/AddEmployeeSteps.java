package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {//extend CommonMethods to use driver
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        //WebElement pimOption=driver.findElement(By.id("menu_pim_viewPimModule"));
       // pimOption.click();
        //after creating objects in Pageinitializer we can call it below instead of above
        click(dashboardPage.pimOption);//call the method click we created in commonmethods instead of Selenium way clicking each time
    }
    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
   WebElement addEmployee= driver.findElement(By.id("menu_pim_addEmployee"));
    addEmployee.click();
    }
    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
      // WebElement firstName=driver.findElement(By.id("firstName"));
       //firstName.sendKeys("soman");
        sendText(addEmployee.firstNameField, "Tatiana");

      // WebElement lastName=driver.findElement(By.id("lastName"));
      // lastName.sendKeys("whatever");
        sendText(addEmployee.lastNameField, "Haughton");
    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
       //WebElement saveBtn=driver.findElement(By.id("btnSave"));
      // saveBtn.click();
        click(addEmployee.saveButton);
    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added");
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String firstName, String lastName) {
        sendText(addEmployee.firstNameField, firstName);
        sendText(addEmployee.lastNameField, lastName);
    }

    @When("user enter {string} and {string} for adding multiple employees")
    public void user_enter_and_for_adding_multiple_employees(String firstNameValue, String lastNameValue) {
        sendText(addEmployee.firstNameField, firstNameValue);
        sendText(addEmployee.lastNameField, lastNameValue);
    }
    }


