package genarrayswap;

public class TestArrayGenerator<T> {
	
	public Integer[] intArr(int i) {
		return new Integer[i];
	}
	public Double[] doubleArr(int i) {
		return new Double[i];
	}
	public String[] stringArr(int i) {
		return new String[i];
	}
	public <T extends Number> void populateMathVal(T t) {
		
	}
	public <T extends Number> boolean comapreArrays(Integer[] intArray, Object[] objects) {
		
		for(int i = 0; i<objects.length; i++) {
			Integer a = intArray[i];
			Integer b = (Integer) objects[i];
			
			if(!a.equals(b)) {
				return false;
			}
		}
		return true;
	}

}
