package data.reservations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import data.zConfuse.DataConfuser;

public class ReservationsController {
	
	//Getters
	private int getNumReservations(String path) throws IOException {
		File f = new File (path + "aacont.txt");
		FileReader fr = new FileReader (f);
		BufferedReader br = new BufferedReader(fr);
		String num = br.readLine();
		br.close();
		return Integer.parseInt(num);
	}
	
	public String[] getReservations(String path) throws IOException {
		FileReader fr = null;
		try {
			int n = getNumReservations(path);
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
					clients[i] = (DataConfuser.decrypt(line.split(" - ")[0]) + " - " 
							+ DataConfuser.decrypt(line.split(" - ")[1]) + " - " 
							+ DataConfuser.decrypt(line.split(" - ")[2]));
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
	
	public boolean checkReservation(String path, String[] date) throws IOException {
		File f = new File (path + "aaall.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		String[] l;
		while ((line = br.readLine()) != null) {
			l = line.split(" - ");
			if ((date[0].trim().equalsIgnoreCase(DataConfuser.decrypt(l[0]).trim().replaceAll(" ", "")))
					&& (date[1].trim().equalsIgnoreCase(DataConfuser.decrypt(l[1]).trim().replaceAll(" ", "")))
					&& (date[2].trim().equalsIgnoreCase(DataConfuser.decrypt(l[2]).trim().replaceAll(" ", "")))) {
						br.close();
						return false;
			}
		}
		br.close();
		return true;
	}
	
	public String getReservationNames(String path, String date) throws IOException {
		File f = new File (path + date + ".txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		br.close();
		return DataConfuser.decrypt(line.split(" - ")[3]);
	}
	
	public boolean addReservation(String path, String[] reservation) throws IOException {
		//Increment number of reservations
		int num = getNumReservations(path);
		File f = new File (path + "aacont.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(Integer.toString(num + 1));
		bw.close();
		//Create client's file
		String res = (DataConfuser.encrypt(reservation[0].trim()) + " - ");
		res += (DataConfuser.encrypt(reservation[1].trim()) + " - ");
		res += (DataConfuser.encrypt(reservation[2].trim()) + " - ");
		res += (DataConfuser.encrypt(reservation[3].trim()));
		String[] date = reservation[0].split("/");
		String resDate = (date[0] + date[1] + date[2]);
		if (reservation[2].equals("Mañana")) {resDate += "M";}
		else {resDate += "T";}
		f = new File (path + resDate + ".txt");
		fw = new FileWriter(f);
		bw = new BufferedWriter(fw);
		bw.write(res);
		bw.close();
		//Add Client to the list
		String toAll = (DataConfuser.encrypt(reservation[0].trim()) + " - ");
		toAll += (DataConfuser.encrypt(reservation[1].trim()) + " - ");
		toAll += (DataConfuser.encrypt(reservation[2].trim()));
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
			bw.write(total + toAll);
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
	
	public boolean removeReservation(String path, String date, String reservation) throws IOException {
		//Decrement number of reservations
		int num = getNumReservations(path);
		File f = new File (path + "aacont.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(Integer.toString(num - 1));
		bw.close();
		//Remove File
		File f2 = new File (path + date + ".txt");
		if (f2.delete()) {
			//Remove name from list
			File f3 = new File(path + "aaall.txt");
			FileReader fr3 = new FileReader (f3);
			BufferedReader br3 = new BufferedReader(fr3);
			String line, total = "";
			while ((line = br3.readLine()) != null) {
				if (!(line.equals(DataConfuser.encrypt(reservation.split(" - ")[0]) + " - " 
						+ DataConfuser.encrypt(reservation.split(" - ")[1]) + " - " + DataConfuser.encrypt(reservation.split(" - ")[2])))) {
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
