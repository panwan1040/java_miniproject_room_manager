import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

public class main {
	public static void main(String[] args) {
		menu box = new menu();
		
		File file = new File("report/report.txt");
		if(!file.isFile()) {
			try {
				FileWriter noteReport = new FileWriter("report/report.txt");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}else {}
		
		File file2 = new File("report/water.txt");
		if(!file2.isFile()) {
			try {
				FileWriter noteReport = new FileWriter("report/water.txt");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}else {}
		
		File file3 = new File("report/waterQ.txt");
		if(!file3.isFile()) {
			try {
				FileWriter noteReport = new FileWriter("report/waterQ.txt");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}else {}
		
		File file4 = new File("report/elec.txt");
		if(!file4.isFile()) {
			try {
				FileWriter noteReport = new FileWriter("report/elec.txt");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}else {}
		
		File file5 = new File("report/elecQ.txt");
		if(!file5.isFile()) {
			try {
				FileWriter noteReport = new FileWriter("report/elecQ.txt");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}else {}
		
		File file6 = new File("report/net.txt");
		if(!file6.isFile()) {
			try {
				FileWriter noteReport = new FileWriter("report/net.txt");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}else {}
		
		File file7 = new File("report/PP.txt");
		if(!file7.isFile()) {
			try {
				FileWriter noteReport = new FileWriter("report/PP.txt");
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}else {}
		
	}
	
}
