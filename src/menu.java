import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class menu extends JFrame implements ActionListener{
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	public int x = 50, x2 = 300;
	public int y1 = 100, y2 = 200, y3 = 300;
	public int wid = 150, hig = 40;
	
	JButton Addbt,Removebt,Perdaybt
		,Permonthbt,Showroombt,Reportbt;
	

	menu() {
		JLabel text = new JLabel("โปรแกรมจัดการห้องพัก");

		setTitle("Room Management");
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		
		Addbt = new JButton("เพิ่มรายชื่อ");
		Removebt = new JButton("ลบรายชื่อ");
		Perdaybt = new JButton("ชำระเงินรายวัน");
		Permonthbt = new JButton("ชำระเงินรายเดือน");
		Showroombt = new JButton("ห้องทั้งหมด");
		Reportbt = new JButton("รายงาน");
		
		//ฟ้อน
		text.setFont(new Font("JasmineUPC",Font.BOLD,40));
		//ฟ้อนปุ่ม
		Addbt.setFont(new Font("JasmineUPC",Font.BOLD,20));
		Perdaybt.setFont(new Font("JasmineUPC",Font.BOLD,20));
		Showroombt.setFont(new Font("JasmineUPC",Font.BOLD,20));
		Removebt.setFont(new Font("JasmineUPC",Font.BOLD,20));
		Permonthbt.setFont(new Font("JasmineUPC",Font.BOLD,20));
		Reportbt.setFont(new Font("JasmineUPC",Font.BOLD,20));
		
		//ตำแหน่ง
		text.setBounds(95, 30, 320,hig );
		
		Addbt.setBounds(x, y1, wid,hig );
		Perdaybt.setBounds(x, y2, wid,hig );
		Showroombt.setBounds(x2, y2, wid,hig );
		Removebt.setBounds(x2, y1, wid,hig );
		Permonthbt.setBounds(x, y3, wid,hig );
		Reportbt.setBounds(x2, y3, wid,hig );
		
		//เพิ่มลงJframe
		getContentPane().add(text);
		getContentPane().add(Addbt);
		getContentPane().add(Perdaybt);
		getContentPane().add(Showroombt);
		getContentPane().add(Removebt);
		getContentPane().add(Permonthbt);
		getContentPane().add(Reportbt);
		
		//การตอบโต้
		Addbt.addActionListener(this);
		Perdaybt.addActionListener(this);
		Showroombt.addActionListener(this);
		Removebt.addActionListener(this);
		Permonthbt.addActionListener(this);
		Reportbt.addActionListener(this);
		
		
		setResizable(false);
		setVisible(true);
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Addbt) {
			Add objectAdd = new Add();
			
		}if(e.getSource() == Removebt) {
			Remove objectAdd = new Remove();
			
		}if(e.getSource() == Perdaybt) {
			try {
				Perday objectAdd = new Perday();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}if(e.getSource() == Permonthbt) {
			Permonth objectAdd = new Permonth();
			
		}if(e.getSource() == Showroombt) {
			Showroom objectAdd = new Showroom();
			
		}if(e.getSource() == Reportbt) {
			Report objectAdd = new Report();
			
		}
		
	}
	
	
}
