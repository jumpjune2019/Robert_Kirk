package genarrayswap;

public class GenArray<T> {
	
	private T[] t;
	
	public GenArray(T[] arg){
		this.t = arg;
	}

	public T[] getT() {
		return t;
	}

	public void setT(T[] t) {
		this.t = t;
	}
	
	public void exchangeVals(int placeA, int placeB) {
		T temp = this.t[placeA];
		this.t[placeA] = this.t[placeB];
		this.t[placeB]= temp; 
	}
	
	public void placeValue(T t, int place) {
		this.t[place] = t; 
	}
	
	@Override
	public String toString() {
		String arrStr = "";
		
		for(T n: this.t) {
			arrStr += n.toString() + " ";
		}
		
		return arrStr;
	}
	
	
}
