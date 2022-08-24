import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Report extends JFrame implements ActionListener{
	
	JButton ok = new JButton("Ok");
	JButton reset = new JButton("Reset");
	
	double sumwaterQ = 0,sumwater= 0,elec= 0,elecQ= 0,net= 0,Allbath = 0;
	int PP = 0;
	
	public Report() {
		setSize(450,500);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		JLabel head = new JLabel("รายงานค่าใช้จ่าย");
		head.setFont(new Font("JasmineUPC",Font.BOLD,40));
		head.setBounds(120, 30, 350, 40);
		getContentPane().add(head);
		
		JLabel line1 = new JLabel("ค่าน้ำ");
		line1.setFont(new Font("JasmineUPC",Font.BOLD,20));
		line1.setBounds(40, 80, 50, 35);
		getContentPane().add(line1);
		
		JLabel line1_1 = new JLabel("ลบ/ม. เป็นเงิน");
		line1_1.setFont(new Font("JasmineUPC",Font.BOLD,20));
		line1_1.setBounds(190, 80, 200, 35);
		getContentPane().add(line1_1);
		
		JLabel line1_2 = new JLabel("บาท");
		line1_2.setFont(new Font("JasmineUPC",Font.BOLD,20));
		line1_2.setBounds(390, 80, 50, 35);
		getContentPane().add(line1_2);
		
		
		JLabel line2 = new JLabel("ค่าไฟ");
		line2.setFont(new Font("JasmineUPC",Font.BOLD,20));
		line2.setBounds(40, 130, 100, 35);
		getContentPane().add(line2);
		
		JLabel line2_1 = new JLabel("หน่วย. เป็นเงิน");
		line2_1.setFont(new Font("JasmineUPC",Font.BOLD,20));
		line2_1.setBounds(190, 130, 200, 35);
		getContentPane().add(line2_1);
		
		JLabel line2_2 = new JLabel("บาท");
		line2_2.setFont(new Font("JasmineUPC",Font.BOLD,20));
		line2_2.setBounds(390, 130, 50, 35);
		getContentPane().add(line2_2);
		
		JLabel line3 = new JLabel("ค่าอินเทอรเน็ต");
		line3.setFont(new Font("JasmineUPC",Font.BOLD,20));
		line3.setBounds(40, 180, 150, 35);
		getContentPane().add(line3);
		
		JLabel line3_1 = new JLabel("บาท");
		line3_1.setFont(new Font("JasmineUPC",Font.BOLD,20));
		line3_1.setBounds(390, 180, 150, 35);
		getContentPane().add(line3_1);
		
		JLabel line4 = new JLabel("รายจ่ายทั้งหมด");
		line4.setFont(new Font("JasmineUPC",Font.BOLD,20));
		line4.setBounds(40, 230, 150, 35);
		getContentPane().add(line4);
		
		JLabel line4_1 = new JLabel("บาท");
		line4_1.setFont(new Font("JasmineUPC",Font.BOLD,20));
		line4_1.setBounds(390, 230, 50, 35);
		getContentPane().add(line4_1);
		
		JLabel line5 = new JLabel("รายได้ทั้งหมด");
		line5.setFont(new Font("JasmineUPC",Font.BOLD,20));
		line5.setBounds(40, 280, 150, 35);
		getContentPane().add(line5);
		
		JLabel line5_1 = new JLabel("บาท");
		line5_1.setFont(new Font("JasmineUPC",Font.BOLD,20));
		line5_1.setBounds(390, 280, 50, 35);
		getContentPane().add(line5_1);
		
		JLabel line6 = new JLabel("กำไร");
		line6.setFont(new Font("JasmineUPC",Font.BOLD,20));
		line6.setBounds(40, 330, 70, 35);
		getContentPane().add(line6);
		
		JLabel line6_1 = new JLabel("บาท");
		line6_1.setFont(new Font("JasmineUPC",Font.BOLD,20));
		line6_1.setBounds(170, 330, 50, 35);
		getContentPane().add(line6_1);
		
		JLabel line6_2 = new JLabel("จากผู้ใช้");
		line6_2.setFont(new Font("JasmineUPC",Font.BOLD,20));
		line6_2.setBounds(220, 330, 80, 35);
		getContentPane().add(line6_2);
		
		JLabel line6_3 = new JLabel("คน");
		line6_3.setFont(new Font("JasmineUPC",Font.BOLD,20));
		line6_3.setBounds(390, 330, 50, 35);
		getContentPane().add(line6_3);
		
		//ค่าน้ำ///ปริมาณ
		java.util.List<String> lines1;
		try {
			lines1 = Files.readAllLines(Paths.get("report/waterQ.txt"));
			String[] l1 =  lines1.stream().toArray(String[]::new);
			
			
			for(int x = 0;x<l1.length;x++) {
				sumwaterQ+= Double.parseDouble(l1[x]);
			}
			JLabel mes1 = new JLabel(sumwaterQ+"");
			mes1.setBounds(115, 80, 100, 30);
			
			getContentPane().add(mes1);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//รวมค่าน้ำ
		java.util.List<String> lines2;
		try {
			lines2 = Files.readAllLines(Paths.get("report/water.txt"));
			String[] l2 =  lines2.stream().toArray(String[]::new);
			
			
			for(int x = 0;x<l2.length;x++) {
				sumwater+= Double.parseDouble(l2[x]);
			}
			JLabel mes2 = new JLabel(sumwater+"");
			mes2.setBounds(320, 80, 100, 30);
			
			getContentPane().add(mes2);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//ค่าไฟ//ปริมาณ
		java.util.List<String> lines3;
		try {
			lines3 = Files.readAllLines(Paths.get("report/elecQ.txt"));
			String[] l3 =  lines3.stream().toArray(String[]::new);
			
			
			for(int x = 0;x<l3.length;x++) {
				elecQ+= Double.parseDouble(l3[x]);
			}
			JLabel mes3 = new JLabel(elecQ+"");
			mes3.setBounds(115, 130, 100, 30);
			getContentPane().add(mes3);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//ค่าไฟ
		java.util.List<String> lines4;
		try {
			lines4 = Files.readAllLines(Paths.get("report/elec.txt"));
			String[] l4 =  lines4.stream().toArray(String[]::new);
			
			
			for(int x = 0;x<l4.length;x++) {
				elec+= Double.parseDouble(l4[x]);
			}
			JLabel mes4 = new JLabel(elec+"");
			mes4.setBounds(320, 130, 100, 30);
			getContentPane().add(mes4);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//ค่าเน็ต
		java.util.List<String> lines5;
		try {
			lines5 = Files.readAllLines(Paths.get("report/net.txt"));
			String[] l5 =  lines5.stream().toArray(String[]::new);
			
			
			for(int x = 0;x<l5.length;x++) {
				net+= Double.parseDouble(l5[x]);
			}
			JLabel mes5 = new JLabel(net+"");
			mes5.setBounds(240, 180, 100, 30);
			getContentPane().add(mes5);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//รายจ่ายทั้งหมด
		double sumAll = sumwater+elec+net;
		JLabel mes6 = new JLabel(sumAll+"");
		mes6.setBounds(240, 230, 100, 30);
		getContentPane().add(mes6);
		
		//รายได้ทั้งหมด
		java.util.List<String> lines7;
		try {
			lines7 = Files.readAllLines(Paths.get("report/report.txt"));
			String[] l7 =  lines7.stream().toArray(String[]::new);
			
			
			for(int x = 0;x<l7.length;x++) {
				Allbath+= Double.parseDouble(l7[x]);
			}
			JLabel mes7 = new JLabel((Allbath)+"");
			mes7.setBounds(240, 280, 100, 30);
			getContentPane().add(mes7);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		JLabel mes8 = new JLabel((Allbath - sumAll)+"");
		mes8.setBounds(100, 330, 100, 30);
		getContentPane().add(mes8);
		
		
		//จำนวนคน
		java.util.List<String> lines9;
		try {
			lines9 = Files.readAllLines(Paths.get("report/PP.txt"));
			String[] l9 =  lines9.stream().toArray(String[]::new);
			
			
			for(int x = 0;x<l9.length;x++) {
				PP+= Integer.parseInt(l9[x]);
			}
			JLabel mes9 = new JLabel(PP+"");
			mes9.setBounds(300, 330, 50, 35);
			getContentPane().add(mes9);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		ok.setBounds(90, 390, 100, 30);
		getContentPane().add(ok);
		
		
		reset.setBounds(250, 390, 100, 30);
		getContentPane().add(reset);
		
		ok.addActionListener(this);
		reset.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ok) {
			dispose();
		}if(e.getSource() == reset) {
			File del1 = new File("report/elec.txt");
			del1.delete();
			
			File del2 = new File("report/elecQ.txt");
			del2.delete();
			
			File del3 = new File("report/net.txt");
			del3.delete();
			
			File del4 = new File("report/PP.txt");
			del4.delete();
			
			File del5 = new File("report/report.txt");
			del5.delete();
			
			File del6 = new File("report/water.txt");
			del6.delete();
			
			File del7 = new File("report/waterQ.txt");
			del7.delete();
			
			Arrays.stream(new File("money/").listFiles()).forEach(File::delete);
	
			File file = new File("report/report.txt");
			if(!file.isFile()) {
				try {
					FileWriter noteReport = new FileWriter("report/report.txt");
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}else {}
			
			File file2 = new File("report/water.txt");
			if(!file2.isFile()) {
				try {
					FileWriter noteReport = new FileWriter("report/water.txt");
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}else {}
			
			File file3 = new File("report/waterQ.txt");
			if(!file3.isFile()) {
				try {
					FileWriter noteReport = new FileWriter("report/waterQ.txt");
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}else {}
			
			File file4 = new File("report/elec.txt");
			if(!file4.isFile()) {
				try {
					FileWriter noteReport = new FileWriter("report/elec.txt");
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}else {}
			
			File file5 = new File("report/elecQ.txt");
			if(!file5.isFile()) {
				try {
					FileWriter noteReport = new FileWriter("report/elecQ.txt");
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}else {}
			
			File file6 = new File("report/net.txt");
			if(!file6.isFile()) {
				try {
					FileWriter noteReport = new FileWriter("report/net.txt");
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}else {}
			
			File file7 = new File("report/PP.txt");
			if(!file7.isFile()) {
				try {
					FileWriter noteReport = new FileWriter("report/PP.txt");
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}else {}
		}
		
	}
}
