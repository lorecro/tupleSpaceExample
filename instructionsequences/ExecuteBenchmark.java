package org.cmg.jresp.instructionsequences;

import org.cmg.jresp.knowledge2.IterativeTupleSpace;
import org.cmg.jresp.knowledge2.Knowledge;
import org.cmg.jresp.knowledge2.TupleSpace;

public class ExecuteBenchmark {
	public static void main(String[] args) throws InterruptedException {
		Knowledge ts = new IterativeTupleSpace();
		int numData = 10 ;
		int numMaxTupleField=10;
		Data data = new Data(numData,numMaxTupleField);
		int numInstruction = 10;
		int numAddedTuple=5;
		InstructionSequences instr = new InstructionSequences(numInstruction, data, numAddedTuple);
		instr.executeSequencesOfInstruction(ts);
	}
}
