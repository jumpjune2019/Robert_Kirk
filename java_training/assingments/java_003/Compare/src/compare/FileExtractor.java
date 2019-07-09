package compare;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class FileExtractor {
	
	private String fileContent;
	
	public String getFileContent() {
		return this.fileContent;
	}
	
	public void setFileContent(String path) {
		List<Character> chars = new ArrayList<Character>();
		try{    
            FileInputStream fin=new FileInputStream(path);   
            
            int i=0;  
            
            while((i=fin.read())!=-1){
            	
            	chars.add((char)i);
             
            }    
            
            fin.close();    
            
          }catch(Exception e){
        	  
        	  System.out.println(e);
        	  
          } 
		StringBuilder sb = new StringBuilder(chars.size());
		for (char c : chars)
		    sb.append(c);
		this.fileContent = sb.toString();
	}
}
