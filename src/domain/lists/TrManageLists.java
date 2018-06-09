package domain.lists;

import java.io.IOException;
import data.CtrlFactory;
import data.clients.ClientsController;
import data.reservations.ReservationsController;
import data.tasks.TasksController;

public class TrManageLists {
	//Attributes
	private CtrlFactory fac = new CtrlFactory();
	
	//Clients
	public String[] getClients(String path) throws IOException {
		ClientsController cont = fac.getClientsController();
		return cont.getClients(path);
	}
	
	public int getNewClientNum(String path) throws IOException {
		ClientsController cont = fac.getClientsController();
		return cont.getNewClientNum(path);
	}
	
	public boolean checkClient(String path, String name) throws IOException {
		ClientsController cont = fac.getClientsController();
		return cont.checkClient(path, name);
	}
	
	public boolean addNewClient(String path, String num, String name, String telf, String mail, String interests) throws IOException {
		ClientsController cont = fac.getClientsController();
		return cont.addNewClient(path, num, name, telf, mail, interests);
	}
	
	public boolean removeClient(String path, String[] info) throws IOException {
		ClientsController cont = fac.getClientsController();
		return cont.removeClient(path, info);
	}
	
	public String[] getInfoClient(String path, String client) throws IOException {
		ClientsController cont = fac.getClientsController();
		return cont.getInfoClient(path, client);
	}
	
	//Reservations
	public String[] getReservations(String path) throws IOException {
		ReservationsController cont = fac.getContactsController();
		return cont.getReservations(path);
	}
	
	public boolean addReservation(String path, String[] reservations) throws IOException {
		ReservationsController cont = fac.getContactsController();
		return cont.addReservation(path, reservations);
	}
	
	public boolean checkReservation(String path, String[] date) throws IOException {
		ReservationsController cont = fac.getContactsController();
		return cont.checkReservation(path, date);
	}
	
	public String getReservationNames(String path, String date) throws IOException {
		ReservationsController cont = fac.getContactsController();
		return cont.getReservationNames(path, date);
	}
	
	public boolean removeReservation(String path, String date, String reservation) throws IOException {
		ReservationsController cont = fac.getContactsController();
		return cont.removeReservation(path, date, reservation);
	}
	
	//tasks
	public String[] getTasks(String path) throws IOException {
		TasksController cont = fac.getTasksController();
		return cont.getTasks(path);
	}
	
	public boolean addTask(String path, String[] task) throws IOException {
		TasksController cont = fac.getTasksController();
		return cont.addTask(path, task);
	}
	
	public boolean checkTask(String path, String name) throws IOException {
		TasksController cont = fac.getTasksController();
		return cont.checkTask(path, name);
	}
	
	public boolean removeTask(String path, String name) throws IOException {
		TasksController cont = fac.getTasksController();
		return cont.removeTask(path, name);
	}
	
	public String getInfoTask(String path, String name) throws IOException {
		TasksController cont = fac.getTasksController();
		return cont.getInfoTask(path, name);
	}
}
