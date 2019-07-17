
public class MyIntNum {
	private int v;
	MyIntNum(int x) { v = x; }
	int getNum() { return v; }
	// Return true if n is a factor of v.
	boolean isFactor(int n) {
		return (v % n) == 0;
	}
}
