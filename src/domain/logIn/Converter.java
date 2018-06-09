package domain.logIn;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Converter {
	//Only the default constructor is used.
	
	//Queries
	protected static String encrypt (String pass) throws UnsupportedEncodingException{
		try {
			//String salt = "IbaUnDiaPorElBosque";
			/*String jarPath = Encrypter.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			jarPath = jarPath.replaceAll("%20", " ");
			jarPath = jarPath.split("Bubu.jar")[0];*/
			String salt = "IbaUnDiaPorElBosque";
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			//Adds the salt
			md.update(salt.getBytes()); 
			//Adds the password at the end and computes the digest
			byte[] bytes = md.digest(pass.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<bytes.length; i++) {
				//Take the bits of each byte, convert it to integer and add it to the result string
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		}
		//No error expected because the encrypting algorithm is already introduced in the code
		catch(NoSuchAlgorithmException e) {return null;}
    }
}
