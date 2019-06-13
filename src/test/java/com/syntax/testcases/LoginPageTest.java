package com.syntax.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest extends BaseClass{

	@Test()
	public void loginToOrangeHRM() {
		
		LoginPageWithoutPageFactory login=new LoginPageWithoutPageFactory();
		
		CommonMethods.sendText(login.username, "Admin");
		CommonMethods.sendText(login.password, "@3wIP5sWVz");
		CommonMethods.click(login.btnLogin);
		
	}
	
	@Test ()
	public void doLogin() {
		LoginPage login =new LoginPage();
		CommonMethods.sendText(login.userName, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);
		
		HomePage home=new HomePage();
		boolean isDisplayed=home.dashboardText.isDisplayed();
		
		Assert.assertTrue(isDisplayed);
	}	
//		@Test
//		public void negativeLogin() {
//			LoginPage login =new LoginPage();
//			CommonMethods.sendText(login.userName, ConfigsReader.getProperty("username1"));
//			CommonMethods.sendText(login.password, ConfigsReader.getProperty("password1"));
//			CommonMethods.click(login.loginBtn);
//			
//			HomePage home=new HomePage();
//			boolean isDisplayed=home.InvalidCredentials.isDisplayed();
//			
//			Assert.assertTrue(isDisplayed);
//		System.out.println("Invalid login");
		
		
	
		
}

