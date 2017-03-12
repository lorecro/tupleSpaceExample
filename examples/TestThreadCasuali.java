package org.cmg.jresp.examples;

import org.cmg.jresp.knowledge2.IterativeTupleSpace;
import org.cmg.jresp.knowledge2.RecursiveTupleSpace;
import org.cmg.jresp.knowledge2.TupleSpace;

public class TestThreadCasuali {
	public static void main(String[] args) throws InterruptedException {
		int numPut = 1000;
		int numGet = 1000;
		int numQuery = 0;
		int numThread = 200;
		int times = 1000;
		for (int j = 0; j < times; j++) {
		TupleSpace ts = new IterativeTupleSpace();
		TestGet[] testget = new TestGet[numGet];
		for (int i = 0; i < numGet; i++) {
			testget[i] = new TestGet(ts);
		}
		TestPut[] testput = new TestPut[numPut];
		for (int i = 0; i < numPut; i++) {
			testput[i] = new TestPut(ts);
		}
		TestQuery[] testquery = new TestQuery[numQuery];
		for (int i = 0; i < numQuery; i++) {
			testquery[i] = new TestQuery(ts);
		}

			Thread[] tr = new Thread[numThread];

			for (int i = 0; i < numThread; i++) {
				if (i % 2 == 0) {
					tr[i] = new Thread(testget[i]);
				} else {
					tr[i] = new Thread(testput[i]);
				}
			}
			
			for (int i = 0; i < numThread; i++) {
				tr[i].start();
			}
			for (int i = 0; i < numThread; i++) {
				tr[i].join();
			}
//			System.out.println("");
		}
	}
}
