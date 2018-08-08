package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

import bean.CanBo;
import bo.CanBoBo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FmCanBo extends JFrame {

	private JPanel contentPane;
	CanBoBo canBoBo = new CanBoBo();
	List<CanBo> listCB = new ArrayList<>();
	private JTextField txtMaCanBo;
	private JTextField txtTenCanBo;
	private JTextField txtHeSoLuong;
	java.awt.List list_1 = new java.awt.List();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FmCanBo frame = new FmCanBo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FmCanBo() {
		getContentPane().setLayout(null);
		
		java.awt.List list = new java.awt.List();
		list.setBounds(34, 10, 110, 185);
		getContentPane().add(list);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
			try {
				listCB = canBoBo.getcb();
				for (CanBo canBo : listCB) {
					list_1.add(canBo.getMacanbo());
					list_1.add(canBo.getHotenn());
					list_1.add(String.valueOf(canBo.getHesoluong()));
					
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("MaCanBo");
		label.setBounds(10, 22, 62, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("TenCanBo");
		label_1.setBounds(10, 73, 62, 22);
		contentPane.add(label_1);
		
		Label label_2 = new Label("HeSoLuong");
		label_2.setBounds(10, 127, 62, 22);
		contentPane.add(label_2);
		
		txtMaCanBo = new JTextField();
		txtMaCanBo.setBounds(93, 24, 86, 20);
		contentPane.add(txtMaCanBo);
		txtMaCanBo.setColumns(10);
		
		txtTenCanBo = new JTextField();
		txtTenCanBo.setText("");
		txtTenCanBo.setBounds(93, 75, 86, 20);
		contentPane.add(txtTenCanBo);
		txtTenCanBo.setColumns(10);
		
		txtHeSoLuong = new JTextField();
		txtHeSoLuong.setBounds(93, 127, 86, 20);
		contentPane.add(txtHeSoLuong);
		txtHeSoLuong.setColumns(10);
		
		JButton btnThem = new JButton("Them");
		btnThem.setBounds(216, 22, 89, 23);
		contentPane.add(btnThem);
		
		JButton btnSua = new JButton("Sua");
		btnSua.setBounds(216, 72, 89, 23);
		contentPane.add(btnSua);
		
		JButton btnXoa = new JButton("Xoa");
		btnXoa.setBounds(216, 126, 89, 23);
		contentPane.add(btnXoa);
		
		JButton btnHienThi = new JButton("Hien Thi");
		btnHienThi.setBounds(216, 171, 89, 23);
		contentPane.add(btnHienThi);
		
		list_1 = new java.awt.List();
		list_1.setBounds(10, 153, 169, 98);
		contentPane.add(list_1);
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String macb = txtMaCanBo.getText();
				String tencb = txtTenCanBo.getText();
				String hsl = txtHeSoLuong.getText();
				try {
					canBoBo.Them(macb, tencb, Double.parseDouble(hsl));
					JOptionPane.showMessageDialog(null, "Them Thanh Cong");
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					canBoBo.Xoa(txtMaCanBo.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				canBoBo.Sua(txtMaCanBo.getText(),
						txtTenCanBo.getText(),
						Double.parseDouble(txtHeSoLuong.getText()));
				
			}
		});
		btnHienThi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					canBoBo.addAll();
					listCB = canBoBo.getcb();
					for (CanBo canBo : listCB) {
						list_1.add(canBo.getHotenn());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		list_1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				CanBo canBo = listCB.get(e.getStateChange() - 1);
				txtMaCanBo.setText(canBo.getMacanbo());
				txtTenCanBo.setText(canBo.getHotenn());
				txtHeSoLuong.setText(canBo.getHesoluong() + "");
			}
		});
	}
}
