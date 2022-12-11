package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id="firstName")
    public WebElement firstNameField;

    @FindBy(id="lastName")
    public WebElement lastNameField;

    @FindBy(id="btnSave")
    public WebElement saveButton;

    public AddEmployeePage(){
        //pageFactory is concept in selenium we use to implement page
        //object model design pattern is responsible to initialize all objects of teh clas
        //objects aka locators aka object repository
        PageFactory.initElements(driver,this);
    }

}
