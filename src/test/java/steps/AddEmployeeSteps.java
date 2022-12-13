package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    @When("user adds multiple employees and verifies they are added successfully")
    public void user_adds_multiple_employees_and_verifies_they_are_added_successfully(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> employeeNames = dataTable.asMaps();

        //getting map from list of maps
        for (Map<String, String> employee : employeeNames
        ) {
            //getting keys and values from every map
            String firstNameValue = employee.get("firstName");
            String middleNameValue = employee.get("middleName");
            String lastNameValue = employee.get("lastName");
            sendText(addEmployee.firstNameField, firstNameValue);
            sendText(addEmployee.lastNameField, lastNameValue);
            sendText(addEmployee.middleNameField, middleNameValue);

            click(addEmployee.saveButton);
            Thread.sleep(2000);

            //one employee has been added up to this point
            //verifying the employee is home-work

            click(dashboardPage.addEmployeeOption);
            Thread.sleep(2000);
        }
    }
        @When("user adds multiple employees from excel using {string} and verifies it")
        public void user_adds_multiple_employees_from_excel_using_and_verifies_it(String sheetName) throws InterruptedException {
         List<Map<String,String>>empFromExcel= ExcelReader.excelListIntoMap(Constants.TESTDATA_FILEPATH,sheetName);
         //returns one map from a list of maps
            Iterator<Map<String,String>> itr=empFromExcel.iterator();
            while(itr.hasNext()){
                Map<String,String>mapNewEmp=itr.next();

                sendText(addEmployee.firstNameField,mapNewEmp.get("firstName"));
                sendText(addEmployee.middleNameField,mapNewEmp.get("middleName"));
                sendText(addEmployee.lastNameField,mapNewEmp.get("lastName"));

                sendText(addEmployee.photograph,mapNewEmp.get("photograph"));

                if(!addEmployee.checkBox.isSelected()) {
                    click(addEmployee.checkBox);
                }

                sendText(addEmployee.createusernameField,mapNewEmp.get("username"));
                sendText(addEmployee.createpasswordField,mapNewEmp.get("password"));
                sendText(addEmployee.confirmpasswordField,mapNewEmp.get("confirmPassword"));

                click(addEmployee.saveButton);

                //verification is in home-work

                Thread.sleep(2000);
                click(dashboardPage.addEmployeeOption);
                Thread.sleep(2000);
            }
        }

    }


