package view.logIn;

import java.io.UnsupportedEncodingException;

import domain.logIn.TrLogIn;

public class CheckPassController {
	//Attributes
	private TrLogIn tl = new TrLogIn();
	
	//Getters
	public boolean checkLogIn(String pass) throws UnsupportedEncodingException {
		return tl.logIn(pass);
	}
}
