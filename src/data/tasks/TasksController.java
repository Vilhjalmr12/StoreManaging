package data.tasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import data.zConfuse.DataConfuser;

public class TasksController {
	
	//Getters
	private int getNumTasks(String path) throws IOException {
		File f = new File (path + "aacont.txt");
		FileReader fr = new FileReader (f);
		BufferedReader br = new BufferedReader(fr);
		String num = br.readLine();
		br.close();
		return Integer.parseInt(num);
	}
	
	public String[] getTasks(String path) throws IOException {
		FileReader fr = null;
		try {
			int n = getNumTasks(path);
			if (n == 0) {
				return new String[n];
			} else {
				String[] clients = new String[n];
				File f = new File(path + "aaall.txt");
				fr = new FileReader (f);
				BufferedReader br = new BufferedReader(fr);
				String line;
				int i = 0;
				while ((line = br.readLine()) != null) {
					clients[i] = DataConfuser.decrypt(line);
					++i;
				}
				return clients;
			}
		}
		catch (FileNotFoundException e) {
			return null;
		}
		finally {
			if (fr != null) {
				fr.close();
			}
		}
	}
	
	public boolean checkTask(String path, String name) throws IOException {
		name = name.toLowerCase().trim().replaceAll(" ", "");
		File f = new File (path + name.trim().replace(" ", "").toLowerCase() + ".txt");
		return !(f.exists());
	}
	
	public boolean addTask(String path, String[] task) throws IOException {
		//Increment number of tasks
		String newLast = (Integer.toString(getNumTasks(path) + 1));
		File f = new File (path + "aacont.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(newLast);
		bw.close();
		//Create task's file
		String res = DataConfuser.encrypt(task[2]);
		f = new File (path + task[0].replaceAll("/", "").trim().replace(" ", "") + task[1].trim().replace(" ", "").toLowerCase() + ".txt");
		fw = new FileWriter(f);
		bw = new BufferedWriter(fw);
		bw.write(res);
		bw.close();
		//Add Client to the list
		FileReader fr = null;
		try {
			f = new File(path + "aaall.txt");
			fr = new FileReader (f);
			BufferedReader br = new BufferedReader(fr);
			String line, total = "";
			while ((line = br.readLine()) != null) {
				total += line + "\n";
			}
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			bw.write(total + DataConfuser.encrypt(task[0]) + " - " + DataConfuser.encrypt(task[1]));
			br.close();
			return true;
		}
		catch (FileNotFoundException e) {
			return false;
		}
		finally {
			if (fr != null) {
				fr.close();
				bw.close();
			}
		}
	}
	
	public String getInfoTask(String path, String name) throws IOException {
		File f2 = new File (path + name.split(" - ")[0].trim().replaceAll("/", "").replaceAll(" ", "") + name.split(" - ")[1].trim().replaceAll(" ", "").toLowerCase() + ".txt");
		FileReader fr2 = new FileReader (f2);
		BufferedReader br2 = new BufferedReader(fr2);
		String notes = "", line;
		while ((line = br2.readLine()) != null) {
			notes += DataConfuser.decrypt(line) + "\n";
		}
		fr2.close();
		br2.close();
		return notes;
	}
	
	public boolean removeTask(String path, String name) throws IOException {
		//Remove File
		File f = new File (path + name.split(" - ")[0].trim().replaceAll("/", "").replaceAll(" ", "") + name.split(" - ")[1].trim().replaceAll(" ", "").toLowerCase() + ".txt");
		if (f.delete()) {
			//Increment number of clients
			String newLast = (Integer.toString(getNumTasks(path) - 1));
			File f2 = new File (path + "aacont.txt");
			FileWriter fw2 = new FileWriter(f2);
			BufferedWriter bw2 = new BufferedWriter(fw2);
			bw2.write(newLast);
			bw2.close();
			//Remove name from list
			File f3 = new File(path + "aaall.txt");
			FileReader fr3 = new FileReader (f3);
			BufferedReader br3 = new BufferedReader(fr3);
			String line, total = "";
			while ((line = br3.readLine()) != null) {
				if (!(DataConfuser.decrypt(line).trim().replace(" ", "").toLowerCase().equals(name.trim().replace(" ", "").toLowerCase()))) {
					total += line + "\n";
				}
			}
			FileWriter fw3 = new FileWriter(f3);
			BufferedWriter bw3 = new BufferedWriter(fw3);
			bw3.write(total);
			br3.close();
			bw3.close();
			return true;
		} else {
			return false;
		}
	}
}
