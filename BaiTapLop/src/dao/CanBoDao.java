package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import bean.CanBo;


public class CanBoDao {
	private ArrayList<CanBo> listCanBo = new ArrayList<>();
	
	public ArrayList<CanBo> getCB() throws Exception{
		listCanBo = new ArrayList<>();
		File f = new File("cbtem.txt");
		FileReader r = new FileReader(f);
		BufferedReader doc = new BufferedReader(r);
		while(true){
			String s = doc.readLine();
			if(s == null)
				break;
			System.out.println(s);
			String arr[] = s.split(" ");
			CanBo canBo = new CanBo(arr[0], arr[1], Double.parseDouble(arr[2]));
			listCanBo.add(canBo);
			
		}
		r.close();
		doc.close();
		
		return listCanBo;
	}
	public boolean addAll(){
		File f = new File("cbtem.txt");
		try {
			FileWriter fw = new FileWriter(f);
			for(CanBo canbo : listCanBo) {
				fw.write(canbo.getMacanbo() + " " + canbo.getHotenn() + " " + canbo.getHesoluong() + "\n");
			}
			System.out.println(listCanBo.size());
			fw.flush();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void addCanBo(String macb,String hoten,double hsl) {
		listCanBo.add(new CanBo(macb, hoten, hsl));
	}
	
	public boolean deleteCB(String macb) throws Exception {
		for (CanBo canBo : listCanBo) {
			if(canBo.getMacanbo().equals(macb)) {
				listCanBo.remove(canBo);
				return true;
			}
		}
		return false;
	}
	
	public boolean editCB(String macb,String hoten,double hsl) {
		for(CanBo canBo : listCanBo) {
			if(canBo.getMacanbo().equals(macb)) {
				canBo.setHotenn(hoten);
				canBo.setHesoluong(hsl);
				return true;
			}
		}
		return false;
	}
}
