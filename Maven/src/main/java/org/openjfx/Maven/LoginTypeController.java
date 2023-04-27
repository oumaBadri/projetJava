package org.openjfx.Maven;

import java.io.IOException;

public class LoginTypeController {
	
	static String logType="";
	
	
	public void switchtoAdmin() throws IOException {
		logType="Admin";
		App.setRoot("LoginAd");
	}
	
	public void switchtoActeur() throws IOException {
		logType="Acteur";
		App.setRoot("AcLogin");
	}
	public void switchtoUser() throws IOException {
		logType="User";
		App.setRoot("loginUser");
	}
	public void switchtoPro() throws IOException {
		logType="Producteur";
		App.setRoot("LoginPro");
	}
	
	

}
