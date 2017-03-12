package org.cmg.jresp.benchmark;

import org.cmg.jresp.knowledge2.*;
public class ExecuteBenchmark {

	public static void main(String[] args) {
		int numFieldsTuple = 10;
		int numOperations = 10000;
		long startTime=0;
		long endTime=0 ;
		long startTimeOLD=0;
		long endTimeOLD=0;
		Knowledge ts = new TemplateIndexedTupleSpace();
		org.cmg.resp.knowledge.ts.TupleSpace ts1 = new  org.cmg.resp.knowledge.ts.TupleSpace();
		CreateData crea = new CreateData(2);
		crea.createData();
		Data data = new Data(crea.getStrings(), crea.getIntegers(), crea.getDoubles(), crea.getBooleans());
//		Benchmark bench = new Benchmark(ts, data, numFieldsTuple, numOperations);
//		BenchmarkOLD bench1 = new BenchmarkOLD(ts1, data, numFieldsTuple, numOperations);
		BenchmarkSameOperation bench = new BenchmarkSameOperation(ts, data, numFieldsTuple, numOperations,ts1);

		try {
			startTime = System.currentTimeMillis();
			bench.executeBenchmark();
			endTime   = System.currentTimeMillis();
//			startTimeOLD =System.currentTimeMillis();
//			bench1.executeBenchmark();
//			endTimeOLD   = System.currentTimeMillis();
//			bench.executeBenchmark();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		ts.firstStamp();
//		long duration = (endTime - startTime);
//		long durationOLD = (endTimeOLD - startTimeOLD);
//		System.out.println("time "+duration);
//		System.out.println("time OLD "+durationOLD);
	}

}
