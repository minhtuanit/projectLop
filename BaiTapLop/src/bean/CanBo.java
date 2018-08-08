package bean;

import java.io.Serializable;

public class CanBo implements Serializable{
	private String macanbo;
	
	private String hotenn;
	private double hesoluong;
	public String getMacanbo() {
		return macanbo;
	}
	
	public CanBo(String macanbo2, String hotenn2, double parseDouble) {
		this.macanbo = macanbo2;
		this.hotenn = hotenn2;
		this.hesoluong = parseDouble;
				}
	public void setMacanbo(String macanbo) {
		this.macanbo = macanbo;
	}
	public String getHotenn() {
		return hotenn;
	}
	public void setHotenn(String hotenn) {
		this.hotenn = hotenn;
	}
	public double getHesoluong() {
		return hesoluong;
	}
	public void setHesoluong(double hesoluong) {
		this.hesoluong = hesoluong;
	}
	
}
