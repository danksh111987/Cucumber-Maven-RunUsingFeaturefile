package com.orangehrm.tests;

import org.testng.annotations.Test;

import com.orangehrm.common.BaseSelenium;
import com.orangehrm.pages.LoginPage;

public class LoginTests extends BaseSelenium {
	//commented for cucumber
	//@Test(dataProvider="excelData", groups={"LoginGroup"})
	@Test
	public void TC1VerifyValidAdminUser(String user, String paswd, String weltxt){
		
		LoginPage lp = new LoginPage();
		lp.isLoginPageLoaded()
			.checkValidLogin(user, paswd)
				.checkWelcometxt(weltxt);
			
		
	}
}
