package org.cmg.jresp.instructionsequences;

import java.util.Random;

import org.cmg.jresp.benchmark.CreateData;
import org.cmg.jresp.knowledge2.Template;
import org.cmg.jresp.knowledge2.Tuple;
import org.cmg.jresp.knowledge2.ActualTemplateField;

public class Data {
	int numData;
	int numMaxTupleField;
	Tuple[] tuples;
	CreateData createData;
	RandomData randomData;
	Random random;

	Data(int numData, int numMaxTupleField) {
		this.numData = numData;
		this.numMaxTupleField=numMaxTupleField;
		this.createData = new CreateData(numMaxTupleField);
		createData.createData();
		this.randomData = new RandomData(createData.getStrings(), createData.getIntegers(), createData.getDoubles(), createData.getBooleans());
		this.random = new Random();
		createTuple();
	}
	
	public void createTuple(){
		tuples = new Tuple[numData];
		int length;
		for(int i =0;i<tuples.length ;i++){
			length = getRandom(numMaxTupleField-1)+1;
			Object[] fields = new Object[length];
			for (int j=0;j<fields.length;j++){
				fields[j]=randomData.getRandomData();
			}
			tuples[i]= new Tuple(fields);
		}
	}
	private int getRandom(int max){
		return random.nextInt(max);
	}
	public Tuple get(int i){
		return tuples[i];
	}
	public Template getRandomFormalTemplate(){
		int n = random.nextInt(numData);
		return tuples[n].getFormalTemplate();
	}
	public Template getRandomActualTemplate(){
		int n = random.nextInt(numData);
		Tuple t = tuples[n];
		int length = t.getLength();
		ActualTemplateField[] fields = new ActualTemplateField[length];
		for(int i=0;i<length;i++){
			fields[i]= new ActualTemplateField(t.get(i));
		}
		return new Template(fields);
	}
}
