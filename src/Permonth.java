import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Permonth extends JFrame implements ActionListener{
	double water =0,electric = 0,internet = 0;
	int x = 20;
	
	String[] PERmonthnumber = new String[31];
	//String[] PERdaynumber = new String[31];
	JComboBox roomnumber;
	JButton cal,pay,cancel;
	
	File file = new File("file/");
	File[] AllnameOffile = file.listFiles();
	String[] number = new String[31];
	String[] line = new String[31];
	String[] getStr = new String[31];
	java.util.List<String> lines;
	
	JLabel box1 = new JLabel();
	JTextField textx ,texty,textz;
	
	public Permonth() {
		setTitle("ชำระค่าบริการรายเดือน");
		setSize(290,410);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		JLabel head = new JLabel("ชำระค่าบริการรายเดือน");
		head.setFont(new Font("JasmineUPC",Font.BOLD,30));
		head.setBounds(x+5, 20, 235, 30);
		getContentPane().add(head);
		
		JLabel text1 = new JLabel("ห้องที่ต้องการ");
		text1.setBounds(x, 80, 100, 30);
		getContentPane().add(text1);
		

		for(int i = 0,o = 1,xx = 1;i < AllnameOffile.length; i++,o++) {
			
			number[o] = (AllnameOffile[i].toString()).substring(5);
			number[o] = number[o].replace(".txt", "");
			if(number[o].indexOf("M") != -1) {
				PERmonthnumber[xx] = number[o];
				xx++;
			}
		}
	
		
		roomnumber = new JComboBox(PERmonthnumber);
		roomnumber.setBounds(x+100, 80, 90, 30);
		getContentPane().add(roomnumber);
		
		
		JLabel name = new JLabel("ชื่อ :");
		name.setBounds(x, 120, 50, 30);
		getContentPane().add(name);
		
		JLabel text2 = new JLabel("ค่าไฟ :");
		JLabel text3 = new JLabel("ค่าน้ำ :");
		JLabel text4 = new JLabel("ค่าอินเตอร์เน็ต :");
		
		
		textx = new JTextField("0");
		texty = new JTextField("0");
		textz = new JTextField("0");
		
		JLabel text6 = new JLabel("หน่วย");
		JLabel text7 = new JLabel("ลบ.ม");
		JLabel text8 = new JLabel("บาท");
		JLabel text9 = new JLabel("บาท");
		
		text2.setBounds(x, 150, 90, 30);
		getContentPane().add(text2);
	//	
		textx.setBounds(70, 155, 150, 20);
		getContentPane().add(textx);
	//	
		text6.setBounds(230, 150, 60, 30);
		getContentPane().add(text6);
		
		text3.setBounds(x, 180, 90, 30);
		getContentPane().add(text3);
	//	
		texty.setBounds(70, 185, 150, 20);
		getContentPane().add(texty);
	//	
		text7.setBounds(230, 180, 60, 30);
		getContentPane().add(text7);
		
		text4.setBounds(x, 210, 190, 30);
		getContentPane().add(text4);
	//	
		
		
		
	//	
		
		
		text8.setBounds(230, 210, 60, 30);
		getContentPane().add(text8);
//เงิน		
		JLabel mon = new JLabel("เป็นเงินจำนวน :");
		mon.setBounds(x, 240, 100, 30);
		getContentPane().add(mon);
		text9.setBounds(230, 240, 60, 30);
		getContentPane().add(text9);
		

//ปุ่มมม		
		
		cal = new JButton("Calculate");
		cal.setBounds(100, 300, 90, 30);
		cal.setEnabled(false);
		getContentPane().add(cal);
		
		pay = new JButton("Pay");
		pay.setBounds(30, 340, 90, 30);
		pay.setEnabled(false);
		getContentPane().add(pay);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(160, 340, 90, 30);
		getContentPane().add(cancel);
		
		cal.addActionListener(this);
		pay.addActionListener(this);
		cancel.addActionListener(this);
		
roomnumber.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					
					String getStr = roomnumber.getSelectedItem().toString();
					
					try {
						java.util.List<String> lines = Files.readAllLines(Paths.get("file/"+getStr+".txt"));
						line =  lines.stream().toArray(String[]::new);
						
						box1.setText(line[0] +"  "+ line[1]);
						
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
					cal.setEnabled(true);
					
				
					
				}else {
					cal.setEnabled(false);
					pay.setEnabled(false);
				}
				///////////////////
				String select = roomnumber.getSelectedItem().toString().replace(" ( M )", "");
				
				
				File file = new File("money/"+select+".txt");
				if(file.isFile()) {
					JOptionPane.showMessageDialog(null,"ผู้ใช้ได้ชำระเงินแล้ว", "คำเตือน" , JOptionPane.ERROR_MESSAGE, null);
					cal.setEnabled(false);
					pay.setEnabled(false);
				}
				File filecheck = new File("check/"+select+".txt");
				if(file.isFile()) {
					textz.setEnabled(false);
				}else if(!file.isFile()) textz.setEnabled(true);
				
		
			}
		});
		
		
		textz.setBounds(120, 215, 100, 20);
		getContentPane().add(textz);
		
		box1.setBounds(x+50, 120, 100, 30);
		getContentPane().add(box1);
		
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == cal) {
			double tx = Double.parseDouble(textx.getText()) ;//electric
			double ty = Double.parseDouble(texty.getText()) ;//water
			double tz = Double.parseDouble(textz.getText());//net
			tool t = new tool();
			
			//tx ปริมาณไฟ
			//ty ปริมาณน้ำ
			//tz ค่าเน็ต
			
			electric = t.ElectricCal(tx);
			water = t.waterCalculate(ty);
			internet = tz;
			
			
			//System.out.println(electric);
			//System.out.println(water);
			
			
			
			
			pay.setEnabled(true);
		
		
		}if(e.getSource() == pay) {
			JOptionPane.showMessageDialog(null, "ชำระเงินเรียบร้อยแล้ว");
			try {
				FileWriter notepay = new FileWriter("money/"+roomnumber.getSelectedItem().toString().replace(" ( M )", "")+".txt");
				notepay.write(electric+"\n"+
				water+"\n"+internet);
				notepay.close();
				
				//รวมเงินทั้งหมดที่ได้
				File report = new File("report/report.txt");
				BufferedWriter buf = new BufferedWriter(new FileWriter(report,true));
				double all = electric +water + internet+3000;
				buf.append(all+"");
				buf.newLine();
				buf.close();
				
				//น้ำ
				File waterC = new File("report/water.txt");
				BufferedWriter buf1 = new BufferedWriter(new FileWriter(waterC,true));
				double all1 = water;
				buf1.append(all1+"");
				buf1.newLine();
				buf1.close();
				
				//น้ำปริมาณ
				File waterQC = new File("report/waterQ.txt");
				BufferedWriter buf2 = new BufferedWriter(new FileWriter(waterQC,true));
				double ty = Double.parseDouble(texty.getText()) ;
				double all2 = ty;
				buf2.append(all2+"");
				buf2.newLine();
				buf2.close();
				
				//ไฟ
				File elecC = new File("report/elec.txt");
				BufferedWriter buf3 = new BufferedWriter(new FileWriter(elecC,true));
				double all3 = electric;
				buf3.append(all3+"");
				buf3.newLine();
				buf3.close();
				
				
				//ไฟปริมาณ
				File elecQC = new File("report/elecQ.txt");
				BufferedWriter buf4 = new BufferedWriter(new FileWriter(elecQC,true));
				double tx = Double.parseDouble(textx.getText()) ;
				double all4 = tx;
				buf4.append(all4+"");
				buf4.newLine();
				buf4.close();
				
				
				//เน็ต
				File netC = new File("report/net.txt");
				BufferedWriter buf5 = new BufferedWriter(new FileWriter(netC,true));
				double all5 = internet;
				buf5.append(all5+"");
				buf5.newLine();
				buf5.close();
				
				File pp = new File("report/PP.txt");
				BufferedWriter buf6 = new BufferedWriter(new FileWriter(pp,true));
				buf6.append("1");
				buf6.newLine();
				buf6.close();
				
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}

			dispose();
			
			
		}if(e.getSource() == cancel) {
			dispose();
		}
		
	}
	
	
}
