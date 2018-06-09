package data;

import data.clients.ClientsController;
import data.logIn.PassController;
import data.reservations.ReservationsController;
import data.tasks.TasksController;

public class CtrlFactory {
	//Getters
	public PassController getPassController() {return new PassController();}
	
	public ClientsController getClientsController() {return new ClientsController();}
	
	public ReservationsController getContactsController() {return new ReservationsController();}
		
	public TasksController getTasksController() {return new TasksController();}
}
