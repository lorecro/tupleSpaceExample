package org.cmg.jresp.benchmark;

public class CreateData {
	String[] strings;
	Integer[] integers;
	Double[] doubles;
	Boolean[] booleans;

	public CreateData(int n) {
		strings = new String[n];
		integers = new Integer[n];
		doubles = new Double[n];
		booleans = new Boolean[2];

	}

	public void createData() {
		createStrings();
		createIntegers();
		createDoubles();
		createBooleans();
	}

	private void createBooleans() {
		booleans[0] = true;
		booleans[1] = false;
	}

	private void createDoubles() {
		for (int i =0;i<doubles.length;i++){
			doubles[i]=Math.sqrt(i+10.0);
		}
	}

	private void createIntegers() {
		for (int i =0;i<integers.length;i++){
			integers[i]=i;
		}
	}

	private void createStrings() {
		for (int i =0;i<integers.length;i++){
			strings[i]="Stringa numero: "+i;
		}
	}

	public String[] getStrings() {
		return strings;
	}

	public void setStrings(String[] strings) {
		this.strings = strings;
	}

	public Integer[] getIntegers() {
		return integers;
	}

	public void setIntegers(Integer[] integers) {
		this.integers = integers;
	}

	public Double[] getDoubles() {
		return doubles;
	}

	public void setDoubles(Double[] doubles) {
		this.doubles = doubles;
	}

	public Boolean[] getBooleans() {
		return booleans;
	}

	public void setBooleans(Boolean[] booleans) {
		this.booleans = booleans;
	}

}
