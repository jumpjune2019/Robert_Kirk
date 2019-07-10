package phone;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Formater {
	
	public String createCol(String str) {
		
		int width = 12;
		
		if(str.length()>width) {
			str = str.substring(0,str.length()-1);
		}
		int spaces = width-str.length();
		for(int i = 0; i<spaces; i++) {
			str+=" ";
		}
		return str;
	}
	public String createRow(String[] arr) {
		String result = "";
		for(int i =0; i<arr.length;i++) {
			result += createCol(arr[i]);
		}
		System.out.println(result);
		return result+="\r\n";
	}
	public void writeHeader(String path) {
		try {
			String header = "PhoneBook App\r\n" + 
							"Name        Phone       City\r\n";
			//FileWriter fw=new FileWriter(path);    
			BufferedWriter writer = new BufferedWriter(
                    new FileWriter(path, true)  //Set true for append mode
                );
			writer.write(header);    
	        writer.close();
		}catch(Exception e) {
			
		}
	}
	public void writeFile(String[] arr) {
		
		
		String path = "D:\\Coding\\JUMP_pro_2019\\Robert_Kirk\\java_training\\assingments\\java_003\\phone\\phone_register.txt";
		try {
			FileReader fr = new FileReader(path);
			if(fr.read()==-1) {
				this.writeHeader(path);
			}
			fr.close();
		}catch(IOException ioe) {
			//File file = new File(path);
			this.writeHeader(path);
		}
		try {
			BufferedWriter writer = new BufferedWriter(
                    new FileWriter(path, true)  //Set true for append mode
                );
			writer.write(this.createRow(arr));    
	        writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
}
