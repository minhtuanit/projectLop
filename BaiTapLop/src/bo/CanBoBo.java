package bo;

import java.util.ArrayList;

import bean.CanBo;
import dao.CanBoDao;

public class CanBoBo {
	CanBoDao cb= new CanBoDao();
	
	public ArrayList<CanBo> getcb() throws Exception{
		return cb.getCB();
		
	}
	
	public void addAll() {
		cb.addAll();
	}
	
	public void Them(String macb, String hoten, double hsl) throws Exception {
		cb.addCanBo(macb, hoten, hsl);
	}
	
	public boolean Xoa(String macb) throws Exception {
		return cb.deleteCB(macb);
	}
	
	public boolean Sua(String macb,String hoten,double hsl) {
		return cb.editCB(macb, hoten, hsl);
	}
}
