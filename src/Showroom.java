import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Showroom extends JFrame implements ActionListener{
	Dimension size = new Dimension(500, 600);
	
	tool tool = new tool();
	//String[] picname = new String[31];
	ImageIcon[] icon = new ImageIcon[31] ;
	
	JLabel name;
	
	
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,
	b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,
	b21,b22,b23,b24,b25,b26,b27,b28,b29,b30;
	
	JLabel[] pic = new JLabel[31];
	
	File file = new File("file/");
	File[] AllnameOffile = file.listFiles();
	String[] number = new String[31];
	
	String[] namenew = new String[31];
	
	File f ;
	

	Showroom() {
		setTitle("รวมห้อง");
		setSize(size);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		for(int loop = 1;loop < 31;loop++) {
			icon[loop] = new ImageIcon("pic/green.png");
		
		}
		
		for(int i = 0,o = 1,xx=1;i < AllnameOffile.length; i++,o++) {
			number[o] = (AllnameOffile[i].toString()).substring(5);
			f = new File("file/"+number[o]);
			//System.out.println(f1.toString());
			
			int namef = Integer.parseInt
					(f.getName().replace(" ( D )", "")
					.replace(" ( M )", "").replace(".txt", ""));
			
			icon[namef] = new ImageIcon("pic/red.png");

			
		}

		
		
		b1 = new JButton("1");
		b1.setBounds(50, 50, 95, 30);
		add(b1);
		pic[1] = new JLabel(icon[1]);
		pic[1].setBounds(20, 50, 30, 30);
		
	
		b2 = new JButton("2");
		b2.setBounds(200, 50, 95, 30);
		add(b2);
		pic[2] = new JLabel(icon[2]);
		pic[2].setBounds(170, 50, 30, 30);

		b3 = new JButton("3");
		b3.setBounds(350, 50, 95, 30);
		add(b3);
		pic[3] = new JLabel(icon[3]);
		pic[3].setBounds(320, 50, 30, 30);

		b4 = new JButton("4");
		b4.setBounds(50, 100, 95, 30);
		add(b4);
		pic[4] = new JLabel(icon[4]);
		pic[4].setBounds(20, 100, 30, 30);

		b5 = new JButton("5");
		b5.setBounds(200, 100, 95, 30);
		add(b5);
		pic[5] = new JLabel(icon[5]);
		pic[5].setBounds(170, 100, 30, 30);

		b6 = new JButton("6");
		b6.setBounds(350, 100, 95, 30);
		add(b6);
		pic[6] = new JLabel(icon[6]);
		pic[6].setBounds(320, 100, 30, 30);

		b7 = new JButton("7");
		b7.setBounds(50, 150, 95, 30);
		add(b7);
		pic[7] = new JLabel(icon[7]);
		pic[7].setBounds(20, 150, 30, 30);

		b8 = new JButton("8");
		b8.setBounds(200, 150, 95, 30);
		add(b8);
		pic[8] = new JLabel(icon[8]);
		pic[8].setBounds(170, 150, 30, 30);

		b9 = new JButton("9");
		b9.setBounds(350, 150, 95, 30);
		add(b9);
		pic[9] = new JLabel(icon[9]);
		pic[9].setBounds(320, 150, 30, 30);

		b10 = new JButton("10");
		b10.setBounds(50, 200, 95, 30);
		add(b10);
		pic[10] = new JLabel(icon[10]);
		pic[10].setBounds(20, 200, 30, 30);

		b11 = new JButton("11");
		b11.setBounds(200, 200, 95, 30);
		add(b11);
		pic[11] = new JLabel(icon[11]);
		pic[11].setBounds(170, 200, 30, 30);

		b12 = new JButton("12");
		b12.setBounds(350, 200, 95, 30);
		add(b12);
		pic[12] = new JLabel(icon[12]);
		pic[12].setBounds(320, 200, 30, 30);

		b13 = new JButton("13");
		b13.setBounds(50, 250, 95, 30);
		add(b13);
		pic[13] = new JLabel(icon[13]);
		pic[13].setBounds(20, 250, 30, 30);

		b14 = new JButton("14");
		b14.setBounds(200, 250, 95, 30);
		add(b14);
		pic[14] = new JLabel(icon[14]);
		pic[14].setBounds(170, 250, 30, 30);

		b15 = new JButton("15");
		b15.setBounds(350, 250, 95, 30);
		add(b15);
		pic[15] = new JLabel(icon[15]);
		pic[15].setBounds(320, 250, 30, 30);

		b16 = new JButton("16");
		b16.setBounds(50, 300, 95, 30);
		add(b16);
		pic[16] = new JLabel(icon[16]);
		pic[16].setBounds(20, 300, 30, 30);

		b17 = new JButton("17");
		b17.setBounds(200, 300, 95, 30);
		add(b17);
		pic[17] = new JLabel(icon[17]);
		pic[17].setBounds(170, 300, 30, 30);

		b18 = new JButton("18");
		b18.setBounds(350, 300, 95, 30);
		add(b18);
		pic[18] = new JLabel(icon[18]);
		pic[18].setBounds(320, 300, 30, 30);

		b19 = new JButton("19");
		b19.setBounds(50, 350, 95, 30);
		add(b19);
		pic[19] = new JLabel(icon[19]);
		pic[19].setBounds(20, 350, 30, 30);

		b20 = new JButton("20");
		b20.setBounds(200, 350, 95, 30);
		add(b20);
		pic[20] = new JLabel(icon[20]);
		pic[20].setBounds(170, 350, 30, 30);

		b21 = new JButton("21");
		b21.setBounds(350, 350, 95, 30);
		add(b21);
		pic[21] = new JLabel(icon[21]);
		pic[21].setBounds(320, 350, 30, 30);

		b22 = new JButton("22");
		b22.setBounds(50, 400, 95, 30);
		add(b22);
		pic[22] = new JLabel(icon[22]);
		pic[22].setBounds(20, 400, 30, 30);

		b23 = new JButton("23");
		b23.setBounds(200, 400, 95, 30);
		add(b23);
		pic[23] = new JLabel(icon[23]);
		pic[23].setBounds(170, 400, 30, 30);

		b24 = new JButton("24");
		b24.setBounds(350, 400, 95, 30);
		add(b24);
		pic[24] = new JLabel(icon[24]);
		pic[24].setBounds(320, 400, 30, 30);

		b25 = new JButton("25");
		b25.setBounds(50, 450, 95, 30);
		add(b25);
		pic[25] = new JLabel(icon[25]);
		pic[25].setBounds(20, 450, 30, 30);

		b26 = new JButton("26");
		b26.setBounds(200, 450, 95, 30);
		add(b26);
		pic[26] = new JLabel(icon[26]);
		pic[26].setBounds(170, 450, 30, 30);

		b27 = new JButton("27");
		b27.setBounds(350, 450, 95, 30);
		add(b27);
		pic[27] = new JLabel(icon[27]);
		pic[27].setBounds(320, 450, 30, 30);

		b28 = new JButton("28");
		b28.setBounds(50, 500, 95, 30);
		add(b28);
		pic[28] = new JLabel(icon[28]);
		pic[28].setBounds(20, 500, 30, 30);

		b29 = new JButton("29");
		b29.setBounds(200, 500, 95, 30);
		add(b29);
		pic[29] = new JLabel(icon[29]);
		pic[29].setBounds(170, 500, 30, 30);

		b30 = new JButton("30");
		b30.setBounds(350, 500, 95, 30);
		add(b30);
		pic[30] = new JLabel(icon[30]);
		pic[30].setBounds(320, 500, 30, 30);
		
		for (int x = 1;x<31;x++)add(pic[x]);
		
		//System.out.println(AllnameOffile.length);
		
		for(int i = 0,o = 1,xx=1;i < AllnameOffile.length; i++,o++) {
			namenew[o] = (AllnameOffile[i].toString()).substring(5);
			//System.out.println(namenew[o]);
		}
		
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		b13.addActionListener(this);
		b14.addActionListener(this);
		b15.addActionListener(this);
		b16.addActionListener(this);
		b17.addActionListener(this);
		b18.addActionListener(this);
		b19.addActionListener(this);
		b20.addActionListener(this);
		b21.addActionListener(this);
		b22.addActionListener(this);
		b23.addActionListener(this);
		b24.addActionListener(this);
		b25.addActionListener(this);
		b26.addActionListener(this);
		b27.addActionListener(this);
		b28.addActionListener(this);
		b29.addActionListener(this);
		b30.addActionListener(this);
		
		

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
//		ลูปเก็บชื่อ		
//		if กดปุ่มแล้วเช็ค เลขปุ่ม+( M ) == ชื่อไฟล์	
//		if กดปุ่มแล้วเช็ค เลขปุ่ม+( D ) == ชื่อไฟล์	
		
		if(e.getSource() == b1) {
			flower(1);
		}if(e.getSource() == b2) {
			flower(2);
		}if(e.getSource() == b3) {
			flower(3);
		}if(e.getSource() == b4) {
			flower(4);
		}if(e.getSource() == b5) {
			flower(5);
		}if(e.getSource() == b6) {
			flower(6);
		}if(e.getSource() == b7) {
			flower(7);
		}if(e.getSource() == b8) {
			flower(8);
		}if(e.getSource() == b9) {
			flower(9);
		}if(e.getSource() == b10) {
			flower(10);
		}if(e.getSource() == b11) {
			flower(11);
		}if(e.getSource() == b12) {
			flower(12);
		}if(e.getSource() == b13) {
			flower(13);
		}if(e.getSource() == b14) {
			flower(14);
		}if(e.getSource() == b15) {
			flower(15);
		}if(e.getSource() == b16) {
			flower(16);
		}if(e.getSource() == b17) {
			flower(17);
		}if(e.getSource() == b18) {
			flower(18);
		}if(e.getSource() == b19) {
			flower(19);
		}if(e.getSource() == b20) {
			flower(20);
		}if(e.getSource() == b21) {
			flower(21);
		}if(e.getSource() == b22) {
			flower(22);
		}if(e.getSource() == b23) {
			flower(23);
		}if(e.getSource() == b24) {
			flower(24);
		}if(e.getSource() == b25) {
			flower(25);
		}if(e.getSource() == b26) {
			flower(26);
		}if(e.getSource() == b27) {
			flower(27);
		}if(e.getSource() == b28) {
			flower(28);
		}if(e.getSource() == b29) {
			flower(29);
		}if(e.getSource() == b30) {
			flower(30);
		}
		
		
	}
	
	public void flower(int num) {
		tool tool = new tool();
		File f1 = new File("file/"+num+" ( D ).txt");
		
		if(f1.isFile())tool.showMore(num+" ( D )");
		
		else if(!f1.isFile()) {
			File ff1 = new File("file/"+num+" ( M ).txt");
			
			if(ff1.isFile()) {
				tool.showMore(num+" ( M )");
			}
			
		}
	}
}
