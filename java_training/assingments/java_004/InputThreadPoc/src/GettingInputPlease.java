import java.io.BufferedInputStream;
import java.io.IOException;

public class GettingInputPlease {
	private boolean notFinished = true;
	public void listening() throws IOException {
		
		while(this.notFinished) {
			//BufferedReader stream = new BufferedReader(new InputStreamReader(System.in));
			//InputStream stream = new InputStream();
			//char[] c= stream.read(c,0,0);
			
			//BufferedInputStream stream = BufferedInputStream(new InputStreamReader(), 1);
			BufferedInputStream stream = new BufferedInputStream(System.in);
			
			stream.mark(0);
			char c = (char) stream.read();
			stream.reset();
			stream.close();
			//stream.read
			System.out.print(c);
			//System.out.println(arr.toString());
			//c = c.toCharArray();
			if(Character.getNumericValue(c)==1) {
				this.notFinished = false;
			}
		}
		
	}
}
