package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class DashboardPage extends CommonMethods {
    //Create dashboard page with all the locators available on that page
    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement empListOption;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmployeeOption;

    @FindBy(id="welcome")
    public WebElement welcomeMessage;

    @FindBy(xpath="//div[@class='menu']/ul/li")
    public List<WebElement> dashboardTabs;

    //next create a constructor to initialize this DashboardPage

    public DashboardPage(){
        PageFactory.initElements(driver, this);
    }


}
