package org.openjfx.Maven;

import java.io.IOException;

public class LoginTypeController {
	
	
	public void switchtoAdmin() throws IOException {
		App.setRoot("LoginAd");
	}
	
	public void switchtoActeur() throws IOException {
		App.setRoot("AcLogin");
	}
	public void switchtoUser() throws IOException {
		App.setRoot("loginUser");
	}
	public void switchtoPro() throws IOException {
		App.setRoot("LoginPro");
	}
	
	

}
