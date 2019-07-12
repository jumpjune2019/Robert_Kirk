package genarrayswap;

//Class takes in a generic type
public class GenArray<T> {
	
	private T[] t;
	
	//constructor instantiates t
	public GenArray(T[] arg){
		this.t = arg;
	}	
	
	//Exchanges values of generic type between two points of the array
	public void exchangeVals(int placeA, int placeB) {
		T temp = this.t[placeA];
		this.t[placeA] = this.t[placeB];
		this.t[placeB]= temp; 
	}
	
	//Getters and setter for the class
	public void placeValue(T t, int place) {
		this.t[place] = t; 
	}
	public T[] getT() {
		return t;
	}

	public void setT(T[] t) {
		this.t = t;
	}
	
	//Custom toString method to ensure that the memory location is not printed
	@Override
	public String toString() {
		String arrStr = "";
		
		for(T n: this.t) {
			arrStr += n.toString() + " ";
		}
		
		return arrStr;
	}
	
	
}
