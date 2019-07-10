package threadpoc;


public class Main {

	public static void main(String[] args) {
		
		
		int n = 9; // Number of threads 
        for (int i=0; i<n; i++) 
        { 
            MultithreadingDemo object = new MultithreadingDemo(); 
            object.start(); 
	     }

   }
}
