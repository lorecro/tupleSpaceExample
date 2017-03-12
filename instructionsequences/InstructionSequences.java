package org.cmg.jresp.instructionsequences;

import java.util.Random;

import org.cmg.jresp.knowledge2.Knowledge;
import org.cmg.jresp.knowledge2.Tuple;

public class InstructionSequences {
	int numInstruction;
	Data data;
	int addedTuple;
	Random random;

	public InstructionSequences(int numInstruction, Data data, int addedTuple) {
		this.numInstruction = numInstruction;
		this.data = data;
		this.addedTuple = addedTuple;
		random = new Random();
	}

	public void executeSequencesOfInstruction(Knowledge ts) throws InterruptedException {
		addTuple(ts);
		getAndQuery(ts);
		
	}
	protected void addTuple(Knowledge ts) throws InterruptedException{
		Tuple t;
		for (int i=0;i<addedTuple;i++){
			t = data.get(i);
			ts.put(t);
		}
	}
	protected void getAndQuery(Knowledge ts) throws InterruptedException{
		boolean j;
		for (int i=0; i< numInstruction;i++){
			j= random.nextBoolean();
			if(j){
				doGet(ts);
			}else {
				doQuery(ts);
			}
		}
	}
	protected void doGet(Knowledge ts) throws InterruptedException{
		boolean i = random.nextBoolean();
		if(i){
			ts.getp(data.getRandomActualTemplate());
		}else{
			ts.getp(data.getRandomFormalTemplate());
		}
	}
	protected void doQuery (Knowledge ts) throws InterruptedException{
		boolean i = random.nextBoolean();
		if(i){
			ts.queryp(data.getRandomActualTemplate());
		}else{
			ts.queryp(data.getRandomFormalTemplate());
		}
	}
}
