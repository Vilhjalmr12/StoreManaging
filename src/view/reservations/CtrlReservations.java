package view.reservations;

import java.io.IOException;
import domain.lists.TrManageLists;
import view.main.JarPath;
import view.main.MainMenu;

public class CtrlReservations {
	//Attributes
	String path = JarPath.getPath() + "Reservas/";
	
	//Setters
	public void setReservations(MainMenu caller) throws IOException {
		TrManageLists tr = new TrManageLists();
		String[] reservations = tr.getReservations(path);
		if (reservations.length == 0) {
			caller.errorMessage("ERROR: No Hay Reservas Registradas");
		}
		caller.setMainDisplayTitle("Reservas");
		caller.setReservations(reservations);
	}
	
	public void addReservation(String[] reservation) throws IOException {
		TrManageLists tr = new TrManageLists();
		tr.addReservation(path, reservation);
	}
	
	public boolean checkReservation(String[] date) throws IOException {
		TrManageLists tr = new TrManageLists();
		return tr.checkReservation(path, date);
	}
	
	public String getReservationNames(String date) throws IOException {
		TrManageLists tr = new TrManageLists();
		return tr.getReservationNames(path, date);
	}
	
	public boolean removeReservation(MainMenu caller, String date, String reservation) throws IOException {
		TrManageLists tr = new TrManageLists();
		return tr.removeReservation(path, date, reservation);
	}
}
