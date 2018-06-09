package domain.logIn;

import java.io.UnsupportedEncodingException;
import data.CtrlFactory;
import data.logIn.PassController;

public class TrLogIn {
	private CtrlFactory fac = new CtrlFactory();
	
	public boolean logIn(String pass) throws UnsupportedEncodingException {
		PassController pc = fac.getPassController();
		return Converter.encrypt(pass).equals(pc.getPass());
	}
}
