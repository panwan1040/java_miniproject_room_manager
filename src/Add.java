import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Add extends JFrame implements ActionListener{
	Dimension size = new Dimension(250,380);
	JTextField name = null,surname = null;
	JLabel textname,textsurname;
	protected int x = 20;
	JComboBox roomnumber,status,net;
	
	JButton btnClose = new JButton("Close");
	JButton btnOk = new JButton("OK");
	
	String select1;
	String select2;
	
	String nameOffile = "";
	String set = "";

	
	
	////////
	static public String PER = "";
	static public boolean[] STATUS = new boolean[30];
	static public  String NET = "";
	//static public boolean[] mode = new boolean[30];
	////////
	
	//boolean monney = true;

	Add() {
		
		setTitle("เพิ่มรายชื่อผู้ใช้บริการ");
		setSize(size);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
//name - surname
		textname = new JLabel("ชื่อ");
		textname.setBounds(x, 20, 50, 30);
		getContentPane().add(textname);
		
		name = new JTextField();
		name.setBounds(x, 50, 200, 30);
		getContentPane().add(name);
//sur
		textsurname = new JLabel("นามสกุล");
		textsurname.setBounds(x, 80, 50, 30);
		getContentPane().add(textsurname);
		
		surname = new JTextField();
		surname.setBounds(x, 110, 200, 30);
		getContentPane().add(surname);
		
//combobox
		JLabel selecroom = new JLabel("โปรดเลือกห้อง");
		selecroom.setBounds(x, 150, 150, 30);
		getContentPane().add(selecroom);
		
		String[] number = {null,"1","2","3","4","5","6","7","8","9","10",
						   "11","12","13","14","15","16","17","18","19","20",
						   "21","22","23","24","25","26","27","28","29","30"				   
		};
		roomnumber = new JComboBox(number);
		roomnumber.setSelectedIndex(0);
		roomnumber.setBounds(x+100, 150, 100, 30);
		getContentPane().add(roomnumber);
//
		
		JLabel statusroom = new JLabel("รูปแบบการพัก");
		statusroom.setBounds(x, 190, 150, 30);
		getContentPane().add(statusroom);
		
		String[] style = {null,"รายวัน","รายเดือน"};
		status = new JComboBox(style);
		status.setSelectedIndex(0);
		status.setBounds(x+100, 190, 100, 30);
		getContentPane().add(status);
		
		
		JLabel textnet = new JLabel("บริการอินเตอเน็ต");
		textnet.setBounds(x, 230, 150, 30);
		getContentPane().add(textnet);
		String[] Arnet ={null,"ต้องการ","ไม่ต้องการ"};
		net = new JComboBox(Arnet);
		net.setSelectedItem(0);
		net.setBounds(x+120, 230, 80, 30);
		getContentPane().add(net);
		
//close
		btnOk.setBounds(20, 290, 80, 30);
		getContentPane().add(btnOk);
		setVisible(true);
		
		btnClose.setBounds(140, 290, 80, 30);
		getContentPane().add(btnClose);
		setVisible(true);
		
		
		//btnOk.setEnabled(false);
		
//เปิด-ปิดปุ่ม ok
		roomnumber.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {

				if ( e.getStateChange () == ItemEvent.SELECTED ) {
					
					select1 = roomnumber.getSelectedItem() + " ( D )";
					set = roomnumber.getSelectedItem() + " ( M )";
					File file = new File("file/"+select1+".txt");
					File file2 = new File("file/"+set+".txt");
					if(file.isFile() || file2.isFile()) {
						JOptionPane.showMessageDialog(null, "ห้องนี้ถูกใช้บริการอยู่กรุณาเลือกห้องอื่น");
						btnOk.setEnabled(false);
					}else btnOk.setEnabled(true);
				}
				
			}
		});
		
		status.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if(status.getSelectedItem().toString() == "รายวัน") {
						
						
						nameOffile = roomnumber.getSelectedItem() + " ( D )";
						net.setEnabled(false);
						//System.out.println(nameOffile);
					}else if(status.getSelectedItem().toString() == "รายเดือน") {
						nameOffile = roomnumber.getSelectedItem() + " ( M )";
						net.setEnabled(true);
						//System.out.println(nameOffile);
					}
				}
				
			}
		});
		
		
		
		btnOk.addActionListener(this);
		btnClose.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == btnOk) {

			try {
				
	//////รายวัน - เดือน
				if(status.getSelectedItem().toString() == "รายวัน") {
					PER = "Per day";
					
					
				}else {
					PER = "Per month";
					if(net.getSelectedItem().toString() == "ต้องการ") {
						NET= "want";
						
					
					}else NET= "notwant";
				}
				
	//////////////เน็ต
				
				
				
				
				
				
				FileWriter note = new FileWriter("file/"+nameOffile+".txt");
				note.write(name.getText() + "\n"
				+surname.getText()+"\n"
				+roomnumber.getSelectedItem()+"\n"
				+PER+"\n"
				+NET);
				
				if(net.getSelectedIndex() == 1) {
				FileWriter note2 = new FileWriter
						("check/"+roomnumber.getSelectedItem().toString()+".txt");
				
				note2.write("want internet");
				note2.close();
				}
				note.close();
				
				
				
				
				dispose();
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
		}if(e.getSource() == btnClose) {
			
			dispose();	
		}
		
	}
}
