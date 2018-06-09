package view.tasks;

import java.io.IOException;
import domain.lists.TrManageLists;
import view.main.JarPath;
import view.main.MainMenu;

public class CtrlTasks {
	//Attributes
	String path = JarPath.getPath() + "Tareas/";
		
	//Setters
	public void setTasks(MainMenu caller) throws IOException {
		TrManageLists tr = new TrManageLists();
		String[] tasks = tr.getTasks(path);
		if (tasks.length == 0) {
			caller.errorMessage("ERROR: No Hay Tareas Registradas");
		} 
		caller.setMainDisplayTitle("Tareas Pendientes");
		caller.setTasks(tasks);
		setComingNotes(caller);
	}
	
	public boolean addTask(String[] task) throws IOException {
		TrManageLists tr = new TrManageLists();
		return tr.addTask(path, task);
	}
	
	public boolean checkTask(String name) throws IOException {
		TrManageLists tr = new TrManageLists();
		return tr.checkTask(path, name);
	}
	
	public boolean removeTask(String name) throws IOException {
		TrManageLists tr = new TrManageLists();
		return tr.removeTask(path, name);
	}
	
	public String getInfoTask(String name) throws IOException {
		TrManageLists tr = new TrManageLists();
		return tr.getInfoTask(path, name);
	}
	
	public void setComingNotes(MainMenu caller) throws IOException {
		TrManageLists tr = new TrManageLists();
		String[] notes = tr.getTasks(path);
		caller.setComingNotes(notes);
	}
}
