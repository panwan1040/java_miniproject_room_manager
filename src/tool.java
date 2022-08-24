import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class tool extends JFrame {

	String[] line = new String[5];
	String[] line2 = new String[5];
	JLabel box1 = new JLabel("");
	JLabel box2 = new JLabel("");
	JLabel box3 = new JLabel("");
	JLabel box4 = new JLabel("");

	public double ElectricCal(double unit) {
		double eletric = 0;

		if (unit <= 0) {
			eletric = 0;
		} else if (unit <= 15) {
			eletric = unit * 2.34;
		} else if (unit <= 25) {
			eletric = unit * 2.98;
		} else if (unit <= 35) {
			eletric = unit * 3.24;
		} else if (unit <= 100) {
			eletric = unit * 3.62;
		} else if (unit <= 150) {
			eletric = unit * 3.71;
		} else if (unit <= 400) {
			eletric = unit * 4.22;
		}

		else {
			eletric = unit * 4.42;
		}

		return eletric;
	}

	public double waterCalculate(double water) {
		double nam = 0;
		if (water > 0) {
			nam = water * 8.50;
		} else if (water > 30) {
			nam = water * 10.03;
		} else if (water > 40) {
			nam = water * 10.35;
		} else if (water > 50) {
			nam = water * 10.68;
		} else if (water > 60) {
			nam = water * 11.00;
		} else if (water > 70) {
			nam = water * 11.33;
		} else if (water > 80) {
			nam = water * 12.50;
		} else if (water > 90) {
			nam = water * 12.82;
		} else if (water > 100) {
			nam = water * 13.15;
		} else if (water > 120) {
			nam = water * 13.47;
		} else if (water > 160) {
			nam = water * 13.80;
		} else if (water > 200)
			nam = water * 14.45;

		return nam;
	}

	public void showMore(String roomSelect) {
		
		setSize(400, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setTitle("ห้องหมายเลข " + roomSelect.replace(" ( M )", "").replace(" ( D )", "").replace(".txt", ""));
		
		JLabel numberR = new JLabel("");
		numberR.setText(roomSelect.replace(" ( M )", "").replace(" ( D )", "").replace(".txt", ""));
		numberR.setFont(new Font("JasmineUPC", Font.BOLD, 60));
		numberR.setBounds(175, 20, 60, 50);
		getContentPane().add(numberR);

		File file = new File("file/");
		File[] AllnameOffile = file.listFiles();
		String[] number = new String[31];
		
		
		JLabel name = new JLabel("ชื่อ :");
		name.setBounds(50, 100, 50, 30);
		getContentPane().add(name);
		box1.setBounds(90, 100, 150, 30);

		JLabel surname = new JLabel("นามสกุล :");
		surname.setBounds(50, 150, 100, 30);
		getContentPane().add(surname);
		box2.setBounds(120, 150, 150, 30);

		JLabel style = new JLabel("รูปแบบการพัก :");
		style.setBounds(50, 200, 100, 30);
		getContentPane().add(style);
		box3.setBounds(150, 200, 150, 30);

		JLabel net = new JLabel("อินเตอร์เน็ต :");
		net.setBounds(50, 250, 100, 30);
		getContentPane().add(net);
		box4.setBounds(140, 250, 150, 30);

		try {

			java.util.List<String> lines = Files.readAllLines(Paths.get("file/" + roomSelect + ".txt"));
			line = lines.stream().toArray(String[]::new);
			//System.out.println(roomSelect);

			box1.setText(line[0]);
			box2.setText(line[1]);
			box3.setText(line[3]);

			File f2 = new File("check/" + roomSelect.replace(" ( M )", "").replace(" ( D )", "") + ".txt");
			//System.out.println(f2.isFile());
			if (f2.isFile()) {

				java.util.List<String> lines2 = Files.readAllLines(
						Paths.get("check/" + roomSelect.replace(" ( M )", "").replace(" ( D )", "") + ".txt"));
				line2 = lines2.stream().toArray(String[]::new);
				box4.setText(line2[0]);
			}else if (!f2.isFile())box4.setText("not want internet");
			else box4.setText("");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getContentPane().add(box1);
		getContentPane().add(box2);
		getContentPane().add(box3);
		getContentPane().add(box4);

		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == ok) {
					dispose();
				}
				
			}
		});
		
		ok.setBounds(170, 300, 60, 30);
		getContentPane().add(ok);
		
		
		setVisible(true);
	
	
	
	}
	
	
/*
	public static void main(String[] args) {
		tool box = new tool();
		box.showMore("");
	}*/
}
