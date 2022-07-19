package testngStepDefinition;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.AccountPage;
import com.pages.LoginPage;
import com.util.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class AccountPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage ; 
	private ConfigReader configReader = new ConfigReader();
	Properties prop = configReader.init_prop();
	
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
	    
		DriverFactory.getDriver().get(prop.getProperty("url"));
		List<Map<String,String>> credList = credTable.asMaps();
	    String username = credList.get(0).get("username");
	    String password = credList.get(0).get("password");
	    
	    
	    try {
			accountPage = loginPage.doLogin(username, password);			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

	@Given("user is on Accounts Page")
	public void user_is_on_accounts_page() {
	   accountPage.getAccountsPageTitle();
	   }

	@Then("user gets account section")
	public void user_gets_account_section(DataTable sectionsTable) {
		List<String> expAccountSectionList= sectionsTable.asList();
		System.out.println("expected Account section List : "+ expAccountSectionList);
		List<String> actualAccountSectionList=accountPage.getAccountsSectionsList();
		System.out.println("actual Account section List : "+ actualAccountSectionList);
		Assert.assertTrue(expAccountSectionList.containsAll(actualAccountSectionList));;
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
	    Assert.assertTrue(accountPage.getAccountsSectioncount()== expectedSectionCount);
	}

}
