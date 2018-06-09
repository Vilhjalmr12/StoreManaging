package data.clients;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import data.zConfuse.DataConfuser;

public class ClientsController {
	//Getters
	private int getNumClients(String path) throws IOException {
		File f = new File (path + "aacont.txt");
		FileReader fr = new FileReader (f);
		BufferedReader br = new BufferedReader(fr);
		String num = br.readLine();
		br.close();
		return Integer.parseInt(num);
	}
	
	public int getNewClientNum(String path) throws IOException {
		File f = new File (path + "aanum.txt");
		FileReader fr = new FileReader (f);
		BufferedReader br = new BufferedReader(fr);
		String num = br.readLine();
		br.close();
		return (Integer.parseInt(num) + 1);
	}
	
	public String[] getClients(String path) throws IOException {
		FileReader fr = null;
		try {
			int n = getNumClients(path);
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
					clients[i] = (DataConfuser.decrypt(line.split(" - ")[0]) + " - " + DataConfuser.decrypt(line.split(" - ")[1]));
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
	
	public boolean checkClient(String path, String name) throws IOException {
		name = name.toLowerCase().trim().replaceAll(" ", "");
		File f = new File (path + "aaall.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null) {
			if (name.equalsIgnoreCase(DataConfuser.decrypt(line.split(" - ")[0]).toLowerCase().trim().replaceAll(" ", ""))) {
				br.close();
				return false;
			}
		}
		br.close();
		return true;
	}
	
	public boolean addNewClient(String path, String num, String name, String telf, String mail, String interests) throws IOException {
		//Increment number of clients and client numbers
		File fnum = new File (path + "aanum.txt");
		FileWriter fwnum = new FileWriter(fnum);
		BufferedWriter bwnum = new BufferedWriter(fwnum);
		bwnum.write(num);
		bwnum.close();
		String s = Integer.toString(getNumClients(path) + 1);
		File fcont = new File (path + "aacont.txt");
		FileWriter fwcont = new FileWriter(fcont);
		BufferedWriter bwcont = new BufferedWriter(fwcont);
		bwcont.write(s);
		bwcont.close();
		
		//Create client's file
		String res = DataConfuser.encrypt(num.trim()) + " - ";
		res += DataConfuser.encrypt(name.trim()) + " - ";
		res += DataConfuser.encrypt(telf.trim()) + " - ";
		res += DataConfuser.encrypt(mail.trim()) + " - ";
		res += DataConfuser.encrypt(interests);
		File f2 = new File (path + num.trim() + ".txt");
		FileWriter fw2 = new FileWriter(f2);
		BufferedWriter bw2 = new BufferedWriter(fw2);
		bw2.write(res);
		bw2.close();
		//Add Client to the list
		String toAll = DataConfuser.encrypt(name.trim()) + " - ";
		toAll += (DataConfuser.encrypt("#" + num.trim()));
		try {
			File fall = new File(path + "aaall.txt");
			FileReader frall = new FileReader (fall);
			BufferedReader brall = new BufferedReader(frall);
			String line, total = "";
			while ((line = brall.readLine()) != null) {
				total += line + "\n";
			}
			FileWriter fwall = new FileWriter(fall);
			BufferedWriter bwall = new BufferedWriter(fwall);
			bwall.write(total + toAll);
			bwall.close();
			brall.close();
			return true;
		}
		catch (FileNotFoundException e) {
			return false;
		}
	}
	
	public String[] getInfoClient(String path, String client) throws IOException {
		String num = client.split(" - #")[1];
		num = num.trim();
		File f = new File (path + num + ".txt");
		FileReader fr = new FileReader (f);
		BufferedReader br = new BufferedReader(fr);
		String line, total = "";
		while ((line = br.readLine()) != null) {
			total += line + "\n";
		}
		String[] res = total.split(" - ");
		for (int i=0; i<res.length; ++i) {
			res[i] = DataConfuser.decrypt(res[i]);
		}
		br.close();
		return res;
	}
	
	public boolean removeClient(String path, String[] info) throws IOException {
		//decrement number of clients
		String s = Integer.toString(getNumClients(path) - 1);
		File fcont = new File (path + "aacont.txt");
		FileWriter fwcont = new FileWriter(fcont);
		BufferedWriter bwcont = new BufferedWriter(fwcont);
		bwcont.write(s);
		bwcont.close();
		//Remove File
		File f = new File (path + info[0].trim() + ".txt");
		if (f.delete()) {
			//Remove name from list
			f = new File(path + "aaall.txt");
			FileReader fr = new FileReader (f);
			BufferedReader br = new BufferedReader(fr);
			String line, total = "";
			while ((line = br.readLine()) != null) {
				if (!(line.equals(DataConfuser.encrypt(info[1]) + " - " + DataConfuser.encrypt("#" + info[0])))) {
					total += line + "\n";
				}
			}
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(total);
			br.close();
			bw.close();
			return true;
		} else {
			return false;
		}
	}
}
