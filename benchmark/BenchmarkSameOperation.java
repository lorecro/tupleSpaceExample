package org.cmg.jresp.benchmark;

import org.cmg.jresp.knowledge2.*;
import org.cmg.resp.knowledge.ts.TupleSpace;
import org.cmg.resp.knowledge.ActualTemplateField;
import org.cmg.resp.knowledge.FormalTemplateField;
import org.cmg.resp.knowledge.Template;
import org.cmg.resp.knowledge.TemplateField;
import org.cmg.resp.knowledge.Tuple;
import org.cmg.resp.knowledge.ts.TupleSpace;

public class BenchmarkSameOperation extends Benchmark {
	long time1 = 0;
	long timeOLD = 0;
	long timeStart = 0;
	long timeEnd = 0;
	TupleSpace ts;

	public BenchmarkSameOperation(Knowledge know, Data data, int numFieldsTuple, int numOperations, TupleSpace ts) {
		super(know, data, numFieldsTuple, numOperations);
		this.ts = ts;
	}

	@Override
	protected void executeRandomOperation() throws InterruptedException {
		int op = random.nextInt(3);
		switch (op) {
		case 0:
			timeStart=System.currentTimeMillis();
			put();
			timeEnd=System.currentTimeMillis();
			time1 +=(timeEnd-timeStart);
			timeStart=System.currentTimeMillis();
			put2();
			timeEnd=System.currentTimeMillis();
			timeOLD +=(timeEnd-timeStart);			
			break;
		case 1:
			timeStart=System.currentTimeMillis();
			get();
			timeEnd=System.currentTimeMillis();
			time1 +=(timeEnd-timeStart);
			timeStart=System.currentTimeMillis();
			get2();
			timeEnd=System.currentTimeMillis();
			timeOLD +=(timeEnd-timeStart);			
			break;
		case 2:
			timeStart=System.currentTimeMillis();
			query();
			timeEnd=System.currentTimeMillis();
			time1 +=(timeEnd-timeStart);
			timeStart=System.currentTimeMillis();
			query2();
			timeEnd=System.currentTimeMillis();
			timeOLD +=(timeEnd-timeStart);			
			break;
		}
	}

	private void put2() throws InterruptedException {
		Object[] fields = new Object[numFieldsTuple];
		for (int i = 0; i < numFieldsTuple; i++) {
			fields[i] = data.getRandomData();
		}
		Tuple t = new Tuple(fields);
		ts.put(t);
	}

	private void get2() throws InterruptedException {
		doGet2(true);
	}

	private void query2() throws InterruptedException {
		doGet2(false);
	}

	private void doGet2(boolean remove) throws InterruptedException {
		int op = random.nextInt(2);
		Template template = null;
		switch (op) {
		case 0:
			template = getFormalTemplate2();
			break;
		case 1:
			template = getActualTemplate2();
			break;
		}
		if (remove) {
			ts.getp(template);
		} else {
			ts.queryp(template);
		}
	}

	private Template getActualTemplate2() {
		TemplateField[] fields = new TemplateField[numFieldsTuple];
		for (int i = 0; i < numFieldsTuple; i++) {
			fields[i] = new ActualTemplateField(data.getRandomData());
		}
		return new Template(fields);
	}

	private Template getFormalTemplate2() {
		TemplateField[] fields = new TemplateField[numFieldsTuple];
		for (int i = 0; i < numFieldsTuple; i++) {
			fields[i] = new FormalTemplateField(data.getRandomData().getClass());
		}
		return new Template(fields);
	}

	@Override
	public void executeBenchmark() throws InterruptedException {
		for (int i = 0; i < numOpertatios; i++) {
			executeRandomOperation();
		}
		System.out.println("tempo nuovo ts "+time1);
		System.out.println("tempo vecchio ts "+timeOLD);


	}
}
