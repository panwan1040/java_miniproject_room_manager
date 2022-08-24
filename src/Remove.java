
import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Remove extends JFrame implements ActionListener{
	Dimension size = new Dimension(300,300);
	JLabel strNumber = new JLabel("ห้องที่ต้องการ"); 
	JLabel name,surname;
	JLabel box1 = new JLabel();
	JLabel box2 = new JLabel();
	JLabel box3 = new JLabel();
	
	JButton remove = new JButton("REMOVE");
	JButton ok = new JButton("OK");
	
	JComboBox roomnumber ;
	
	protected int x = 20;
	
	File file = new File("file/");
	File[] AllnameOffile = file.listFiles();
	String[] number = new String[31];
	String[] line = new String[5];
	
	
	Remove() {
		number[0] = null;
		setTitle("ลบรายชื่อผู้ใช้บริการ");
		setSize(size);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		//getContentPane().setBackground(Color.green);
		
//add ข้อความ
		
		strNumber.setBounds(x, 20, 90, 30);
		getContentPane().add(strNumber);
		
		name = new JLabel("ชื่อ :");
		name.setBounds(x, 50, 50, 30);
		getContentPane().add(name);
		
		surname = new JLabel("นามสกุล :");
		surname.setBounds(x, 80, 60, 30);
		getContentPane().add(surname);
		

		
//ตัดสตริง		
		for(int i = 0,o = 1;i < AllnameOffile.length; i++,o++) {
			//System.out.println(AllnameOffile[i]);
			number[o] = (AllnameOffile[i].toString()).substring(5);
			number[o] = number[o].replace(".txt", "");
			
			
		}
		
		
		roomnumber = new JComboBox(number);
		roomnumber.setBounds(120, 20, 100, 30);
		roomnumber.setSelectedIndex(0);
		getContentPane().add(roomnumber);
		
		roomnumber.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					try {
						
						String getStr = roomnumber.getSelectedItem().toString();
						//System.out.println(getStr);
						
						java.util.List<String> lines = Files.readAllLines(Paths.get("file/"+getStr+".txt"));
						
						line =  lines.stream().toArray(String[]::new);
						box1.setText(line[0]);
						box2.setText(line[1]);
						
						File f1 = new File("money/"+roomnumber.getSelectedItem().toString().replace(" ( M )", "").replace(" ( D )", "")+".txt");
						
						
						//System.out.println(f1);
						if(f1.isFile()) {
							
							box3.setText("ผู้ใช้บริการชำระเงินเรียบร้อยแล้ว");
						}else  {
							
							box3.setText("ผู้ใช้บริการยังไม่ได้ชำระเงิน");
							
						}
		
					} catch (FileNotFoundException e1) {
						
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
				
			}
		});
		
		
		
		box1.setBounds(x+30, 50, 200, 30);
		getContentPane().add(box1);
		
		box2.setBounds(x+60, 80, 200, 30);
		getContentPane().add(box2);
		
		box3.setBounds(x+30, 120, 200, 30);
		getContentPane().add(box3);

	//button
		
		remove.setBounds(x, 220, 100, 30);
		getContentPane().add(remove);
		
		ok.setBounds(x+150, 220, 100, 30);
		getContentPane().add(ok);
		
		remove.addActionListener(this);
		ok.addActionListener(this);
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == remove) {
			
			File delfile = new File("file/"+roomnumber.getSelectedItem()+".txt");
			
			File delcheck = new File("check/"+roomnumber.getSelectedItem().toString().replace(" ( M )", "").replace(" ( D )", "")+".txt");
			
			File delmon = new File("money/"+roomnumber.getSelectedItem().toString().replace(" ( M )", "").replace(" ( D )", "")+".txt");
			
			
			//System.out.println(delmon);
			
			if (!delmon.isFile()) {
			int yn = JOptionPane.showConfirmDialog(null, "ผู้ใช้บริการยังไม่ได้ชำระค่าบริการ ต้องการลบข้อมูลหรือไม่","คำเตือน", JOptionPane.YES_NO_OPTION);
					if(yn == 0) {
						
						delcheck.delete();
						delfile.delete();
						delmon.delete();
						dispose();
						
					}else if(yn == 1) {
						 
						
					}
				
					
			}else {
				JOptionPane.showMessageDialog(null, "ลบรายชื่อแล้ว");
				delcheck.delete();
				delfile.delete();
				delmon.delete();
				dispose();
			}
			
		
			
		}
		if(e.getSource() == ok) {
			dispose();
		}
		
	}
}
