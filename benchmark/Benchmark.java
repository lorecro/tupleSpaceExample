package org.cmg.jresp.benchmark;

import java.util.Random;

import org.cmg.jresp.knowledge2.ActualTemplateField;
import org.cmg.jresp.knowledge2.FormalTemplateField;
import org.cmg.jresp.knowledge2.Knowledge;
import org.cmg.jresp.knowledge2.Template;
import org.cmg.jresp.knowledge2.TemplateField;
import org.cmg.jresp.knowledge2.Tuple;

public class Benchmark {
	Knowledge ts;
	Data data;
	int numFieldsTuple;
	int numOpertatios;
	Random random;

	public Benchmark(Knowledge ts, Data data, int numFieldsTuple, int numOperations) {
		this.ts = ts;
		this.data = data;
		this.numFieldsTuple = numFieldsTuple;
		this.numOpertatios = numOperations;
		this.random = new Random();
	}
	
	protected void executeRandomOperation() throws InterruptedException {
		int op = random.nextInt(3);
		switch (op) {
		case 0:
			put();
			break;
		case 1:
			get();
			break;
		case 2:
			query();
			break;
		}
	}

	public void executeBenchmark() throws InterruptedException {
		for (int i = 0; i < numOpertatios; i++) {
			executeRandomOperation();
	//		ts.firstStamp();
		}
	}

	protected void put() throws InterruptedException {
		Object[] fields = new Object[numFieldsTuple];
		for (int i = 0; i < numFieldsTuple; i++) {
			fields[i] = data.getRandomData();
		}
		Tuple t = new Tuple(fields);
		ts.put(t);
	}

	protected void get() throws InterruptedException {
		doGet(true);
	}

	protected void query() throws InterruptedException {
		doGet(false);
	}

	private void doGet(boolean remove) throws InterruptedException {
		int op = random.nextInt(2);
		Template template = null;
		switch (op) {
		case 0: template = getFormalTemplate();
			break;
		case 1: template = getActualTemplate();
			break;
		}
		if (remove){
			ts.getp(template);
		}else{
			ts.queryp(template);
		}
	}

	private Template getActualTemplate() {
		TemplateField[] fields = new TemplateField[numFieldsTuple];
		for (int i=0;i<numFieldsTuple;i++){
			fields[i] = new ActualTemplateField(data.getRandomData());
		}
		return new Template(fields);
	}

	private Template getFormalTemplate() {
		TemplateField[] fields = new TemplateField[numFieldsTuple];
		for (int i=0;i<numFieldsTuple;i++){
			fields[i] = new FormalTemplateField(data.getRandomData().getClass());
		}
		return new Template(fields);
	}
}
