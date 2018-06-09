package view.client;

import java.io.IOException;

import domain.lists.TrManageLists;
import view.main.JarPath;
import view.main.MainMenu;

public class CtrlClients {
	//Attributes
	String path = JarPath.getPath() + "Clientes/";
		
	//Setters
	public void setClients(MainMenu caller) throws IOException {
		TrManageLists tr = new TrManageLists();
		String[] clients = tr.getClients(path);
		if (clients.length == 0) {
			caller.errorMessage("ERROR: No Hay Clientes Registrados");
		}
		caller.setMainDisplayTitle("KekoAmigos");
		caller.setClients(clients);
	}
	
	protected int getNewClientNum(ClientNew caller) {
		TrManageLists tr = new TrManageLists();
		try {
			return (tr.getNewClientNum(path));
		} catch (IOException e) {
			caller.errorMessage("INTERNAL ERROR!");
			return -1;
		}
	}
	
	protected boolean checkClient(String name) throws IOException {
		TrManageLists tr = new TrManageLists();
		return tr.checkClient(path, name);
	}
	
	protected boolean createNewClient(String num, String name, String telf, String mail, String interests) throws IOException {
		TrManageLists tr = new TrManageLists();
		return tr.addNewClient(path, num, name, telf, mail, interests);
	}
	
	protected String[] getInfoClient(String client) throws IOException {
		TrManageLists tr = new TrManageLists();
		return tr.getInfoClient(path, client);
	}
	
	protected boolean removeClient(String[] info) throws IOException {
		TrManageLists tr = new TrManageLists();
		return tr.removeClient(path, info);
	}
}
