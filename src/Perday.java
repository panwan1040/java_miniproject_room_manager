import java.awt.Font;
import java.awt.List;
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
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Perday extends JFrame implements ActionListener{
	int x = 20;
	
	
	//	ชื่อ
	//	นามสกุล
	//	เลขห้อง
	//	per day/per month
	
	String[] PERmonthnumber = new String[31];
	String[] PERdaynumber = new String[31];
	JComboBox roomnumber;
	JButton cal,pay,cancel;
	JLabel resalt = new JLabel();
	
	
	File file = new File("file/");
	File[] AllnameOffile = file.listFiles();
	String[] number = new String[31];
	String[] line = new String[31];
	String[] getStr = new String[31];
	java.util.List<String> lines;
	
	JLabel box1 = new JLabel();
	
	Perday() throws IOException {
		setTitle("ชำระค่าบริการรายวัน");
		setSize(290,410);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		JLabel head = new JLabel("ชำระค่าบริการรายวัน");
		head.setFont(new Font("JasmineUPC",Font.BOLD,30));
		head.setBounds(x+20, 20, 220, 30);
		getContentPane().add(head);
		
		JLabel text1 = new JLabel("ห้องที่ต้องการ");
		text1.setBounds(x, 80, 90, 30);
		getContentPane().add(text1);

//เรียกไฟล์		
		
		for(int i = 0,o = 1,xx = 1;i < AllnameOffile.length; i++,o++) {
			
			number[o] = (AllnameOffile[i].toString()).substring(5);
			number[o] = number[o].replace(".txt", "");
		//System.out.println(number[o].indexOf("M"));	
			if(number[o].indexOf("D") != -1) {
				PERdaynumber[xx] = number[o];
				xx++;
			}
				
	
		}
		
	
	
		
		roomnumber = new JComboBox(PERdaynumber);
		
		
	
		
		roomnumber.setBounds(x+100, 80, 90, 30);
		getContentPane().add(roomnumber);
		
		JLabel name = new JLabel("ชื่อ :");
		name.setBounds(x, 120, 50, 30);
		getContentPane().add(name);
		
		JLabel text2 = new JLabel("ค่าไฟ :");
		JLabel text3 = new JLabel("ค่าน้ำ :");
		JLabel text4 = new JLabel("ค่าอินเตอร์เน็ต :");
		
		JLabel textx,texty,textz;
		textx = new JLabel("-");
		texty = new JLabel("-");
		textz = new JLabel("-");
		
		JLabel text6 = new JLabel("หน่วย");
		JLabel text7 = new JLabel("ลบ.ม");
		JLabel text8 = new JLabel("บาท");
		JLabel text9 = new JLabel("บาท");
		
		text2.setBounds(x, 150, 90, 30);
		getContentPane().add(text2);
		textx.setBounds(140, 150, 20, 30);
		getContentPane().add(textx);
		text6.setBounds(230, 150, 60, 30);
		getContentPane().add(text6);
		
		text3.setBounds(x, 180, 90, 30);
		getContentPane().add(text3);
		texty.setBounds(140, 180, 20, 30);
		getContentPane().add(texty);
		text7.setBounds(230, 180, 60, 30);
		getContentPane().add(text7);
		
		text4.setBounds(x, 210, 190, 30);
		getContentPane().add(text4);
		textz.setBounds(140, 210, 20, 30);
		getContentPane().add(textz);
		text8.setBounds(230, 210, 60, 30);
		getContentPane().add(text8);
//เงิน		
		JLabel mon = new JLabel("เป็นเงินจำนวน :");
		mon.setBounds(x, 240, 100, 30);
		getContentPane().add(mon);
		text9.setBounds(230, 240, 60, 30);
		getContentPane().add(text9);
		
//ปุ่ม		
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
					//pay.setEnabled(true);
					
					
					
				}else {
					cal.setEnabled(false);
					pay.setEnabled(false);
				}
				///////////////////
				String select = roomnumber.getSelectedItem().toString().replace(" ( D )", "");
				File file = new File("money/"+select+".txt");
				if(file.isFile()) {
					JOptionPane.showMessageDialog(null,"ผู้ใช้ได้ชำระเงินแล้ว", "คำเตือน" , JOptionPane.ERROR_MESSAGE, null);
					pay.setEnabled(false);
				}
				
		
			}
		});
		
		
		resalt.setBounds(140, 240, 100, 30);
		getContentPane().add(resalt);
		
		box1.setBounds(x+50, 120, 100, 30);
		getContentPane().add(box1);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cal) {
			resalt.setText("400");
			pay.setEnabled(true);
			
		}if(e.getSource() == pay) {
			JOptionPane.showMessageDialog(null, "ชำระเงินเรียบร้อยแล้ว");
			try {
				FileWriter notepay = new FileWriter("money/"+roomnumber.getSelectedItem().toString().replace(" ( D )", "")+".txt");
				notepay.write("400");
				notepay.close();
				
				File report = new File("report/report.txt");
				BufferedWriter buf = new BufferedWriter(new FileWriter(report,true));
				buf.append("400");
				buf.newLine();
				buf.close();
				
				File pp = new File("report/PP.txt");
				BufferedWriter buf2 = new BufferedWriter(new FileWriter(pp,true));
				buf2.append("1");
				buf2.newLine();
				buf2.close();
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}

			dispose();
			
		}if(e.getSource() == cancel) {
			dispose();
		}
		
	}
}
